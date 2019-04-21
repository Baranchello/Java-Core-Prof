import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test_ArrayChecker
{
  @Parameterized.Parameters
  public static Collection<Object[]> data()
  {
    return Arrays.asList(new Object[][]{
      {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
      {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{5, 2}} //тест на проверку цифр после последний 4 (testArrayChecker) не должен пройти
    });
  }

  private int[] in;
  private int[] out;

  public Test_ArrayChecker(int[] in, int[] out)
  {
    this.in = in;
    this.out = out;
  }

  private ArrayChecker arrayChecker;

  @Before
  public void startTest()
  {
    arrayChecker = new ArrayChecker();
  }

  @Test
  public void testArrayChecker()
  {
    Assert.assertArrayEquals(out, ArrayChecker.After4(in));
  }

  @Test(expected = RuntimeException.class)
  public void testArrayEx()
  {
    ArrayChecker.After4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
  }
}