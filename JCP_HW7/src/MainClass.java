import almihchernov.test.*;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.Comparator;

public class MainClass
{

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Class test_class = TestClass.class;

    Object test_obj = test_class.newInstance();

    try
    {
      start(test_class, test_obj);
    }
    catch (InvocationTargetException e)
    {
      e.printStackTrace();
    }

  }


  public static void start(Class test_class, Object testObj) throws InvocationTargetException, IllegalAccessException {
    ArrayList<Method> al = new ArrayList<>();
    Method beforeMethod = null;
    Method afterMethod = null;

    for (Method o : test_class.getDeclaredMethods())
    {
      if (o.isAnnotationPresent(Test.class))
      {
        al.add(o);
      }

      if (o.isAnnotationPresent(BeforeSuite.class))
      {
        if (beforeMethod == null) beforeMethod = o;
        else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
      }

      if (o.isAnnotationPresent(AfterSuite.class))
      {
        if (afterMethod == null) afterMethod = o;
        else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
      }

      al.sort(new Comparator<Method>()
      {
        @Override
        public int compare(Method o1, Method o2)
        {
          return o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority();
        }
      });
    } // end of for (Method o : c.getDeclaredMethods())


    if (beforeMethod != null) beforeMethod.invoke(testObj, null);

    for (Method o : al) o.invoke(testObj, null);

    if (afterMethod != null) afterMethod.invoke(testObj, null);

  }


}

