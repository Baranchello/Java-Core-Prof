import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test_Is_1_or_4
{
  @Parameterized.Parameters
  public static Collection<Object[]> data()
  {
    return Arrays.asList(new Object[][]{
      {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
      {new int[]{8, 8, 7, 7, 7, 3, 5, 1}, false},
      {new int[]{2, 3, 8, 7}, true} //с этим набором данных тест не должен пройти, т.к. ожидаемый результата задан некорректно
    });
  }

  private int[] in;
  private boolean out;


  public Test_Is_1_or_4(int[] in, boolean out)
  {
    this.in = in;
    this.out = out;
  }

  private IsOnly1and4 isOnly1and4;

  @Before
  public void startTest()
  {
    isOnly1and4 = new IsOnly1and4();
  }

  @Test
  public void testOnly1And4()
  {
    Assert.assertEquals(IsOnly1and4.Is_1_or_4(in), out);
  }
}