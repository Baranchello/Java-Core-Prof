import java.util.concurrent.CyclicBarrier;

public class Signal
{
  private CyclicBarrier barrier;

  public Signal(String message, int size)
  {
    this.barrier = new CyclicBarrier(size, () -> System.out.println(message));
  }

  public CyclicBarrier getBarrier()
  {
    return barrier;
  }
}