import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

public class Race
{

  private ArrayList<Stage> stages;
  private ArrayList<Car> cars;
  private AtomicReference<Car> winner;

  static Signal sign_start  = new Signal("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!", MainClass.CARS_COUNT);
  static Signal sign_finish = new Signal("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка завершилась!!!", MainClass.CARS_COUNT);;


  public Race(Stage[] stages, int participantQuantity)
  {
    Car[] cars = new Car[participantQuantity];
    for (int i = 0; i < cars.length; i++)
    {
      cars[i] = new Car(20 + (int) (Math.random() * 10));
    }

    this.stages = new ArrayList<>(Arrays.asList(stages));
    this.cars = new ArrayList<>(Arrays.asList(cars));
    this.winner = new AtomicReference<>();
  }

  public ArrayList<Stage> getStages()
  {
    return stages;
  }

  public CyclicBarrier getStartSignal(Signal sign)
  {
    return sign.getBarrier();
  }

  public CyclicBarrier getFinishSignal(Signal sign)
  {
    return sign.getBarrier();
  }

  public void setWinner(Car winner)
  {
    boolean result = this.winner.compareAndSet(null, winner);
    if (result)
    {
      System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + winner.getName() + " победил!!!");
    }
  }

  public void start()
  {
    for (Car car : cars)
    {
      car.addToRace(this);
    }

    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    for (Car car : cars) {
      new Thread(car).start();
    }
  }

}