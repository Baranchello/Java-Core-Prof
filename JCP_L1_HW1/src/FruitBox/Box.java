package FruitBox;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>
{
  private ArrayList<T> inBox = new ArrayList<>();
  private final float DELTA = 0.00001f;



  public void addFruit(T fruit, int count)
  {
    if (count <= 0) System.out.println("Нельзя добавить 0 или меньше фруктов в карзину!");
    else
      {
        for (int i = 0; i < count; i++) this.inBox.add(fruit);
      }
  }

  public float getWeight()
  {
    float result = 0.0f;
    for (T elm: inBox)
    {
     result += elm.getWeight();
    }
    System.out.println("Масса коробки: " + result);
    return result;
  }

  public boolean cmp(Box other)
  {
    boolean result = (Math.abs(this.getWeight() - other.getWeight()) < 0.0001);
    System.out.println("Результат стравнения коробок: " + result);
    return result;
  }

  public void replaceto(Box other)
  {
    other.inBox.addAll(this.inBox);
    this.inBox.clear();
  }

}
