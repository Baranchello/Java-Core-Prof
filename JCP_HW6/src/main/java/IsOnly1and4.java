public class IsOnly1and4
{
  public static boolean Is_1_or_4(int[] arr)
  {
    boolean is_1 = false;
    boolean is_4 = false;

    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 1) is_1 = true;
      else if (arr[i] == 4) is_4 = true;
    }


    return is_1 && is_4;
  }
}