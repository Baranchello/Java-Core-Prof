public class NotifyWait
{
  private final Object mon = new Object();
  private volatile char currentLetter = 'A';
  private int NUMBER_CHAR = 5;

  private void printA()
  {
    synchronized (mon)
    {
      try
      {
        for (int i = 0; i < NUMBER_CHAR; i++)
        {
          while (currentLetter != 'A') mon.wait();
          System.out.print("A");
          currentLetter = 'B';
          mon.notifyAll();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void printB()
  {
    synchronized (mon)
    {
      try
      {
        for (int i = 0; i < NUMBER_CHAR; i++)
        {
          while (currentLetter != 'B') mon.wait();
          System.out.print("B");
          currentLetter = 'C';
          mon.notifyAll();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void printC()
  {
    synchronized (mon)
    {
      try
      {
        for (int i = 0; i < NUMBER_CHAR; i++)
        {
          while (currentLetter != 'C') mon.wait();
          System.out.print("C");
          currentLetter = 'A';
          mon.notifyAll();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void printSeq()
  {
    new Thread(() -> {
      printA();
    }).start();
    new Thread(() -> {
      printB();
    }).start();

    new Thread(() -> {
      printC();
    }).start();
  }
}

