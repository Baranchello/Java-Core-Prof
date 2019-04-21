package almihchernov.test;

public class TestClass
{
  @BeforeSuite
  public void begin()
  {
    System.out.println("Начало (по аннатоции BeforeSuite)");
  }

  @Test(priority = 1)
  public void test1()
  {
    System.out.println("Тест №1 - Приоритет = 1");
  }

  @Test
  public void test2()
  {
    System.out.println("Тест №2 - Приоритет = По умолчанию (5)");
  }

  @Test(priority = 3)
  public void test3()
  {
    System.out.println("Тест №3 - Приоритет = 3");
  }

  @Test(priority = 10)
  public void test4()
  {
    System.out.println("Тест №4 - Приоритет = 10");
  }

  public void test5()
  {
    System.out.println("Тест №5 - Приоритет = 5"); //если все ОК - печати не будет
  }

  @AfterSuite
  public void end()
  {
    System.out.println("Конец (по аннатоции AfterSuite)");
  }

}
