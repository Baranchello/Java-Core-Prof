import java.util.ArrayList;
import java.util.Arrays;

import FruitBox.*;

public class MainClass {

  public static void main(String[] args) {

    Integer[] array1 = {1, 2, 3, 4, 5};
    String[]  array2 = {"Мама", "мыла", "раму"};

    try
    {
      swap(array1, 2, 4);
      swap(array2, 1, 2);
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("Ошибка индексации при вызове функции swap!");
      e.printStackTrace();
    }

    toList(array2);

    Box<Apple>  box1_apple  = new Box<>();
    Box<Apple>  box2_apple  = new Box<>();
    Box<Orange> box1_orange = new Box<>();

    box1_apple.addFruit (new Apple() , 15);
    box1_orange.addFruit(new Orange(), 10);

    System.out.println("Коробка яблок №1 весит: " + box1_apple.getWeight());
    System.out.println("Коробка апельсинов №1 весит: " + box1_orange.getWeight());
    box1_apple.cmp(box1_orange);
    System.out.println("Добавим еще одно яблоко...");
    box1_apple.addFruit (new Apple() , 1);
    box1_apple.cmp(box1_orange);

    box1_apple.replaceto(box2_apple);
    System.out.println("После перемещения яблок из первой коробки в ней осталось: " + box1_apple.getWeight());
    System.out.println("во второй коробке: " + box2_apple.getWeight());


  }

  //метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
  public static void swap(Object[] arr, int elm1, int elm2) throws ArrayIndexOutOfBoundsException
  {
    System.out.println("Исходный массив: " + Arrays.toString(arr));

    Object tmp = arr[elm1];
    arr[elm1] = arr[elm2];
    arr[elm2] = tmp;

    System.out.println("Преобразованный массив: " + Arrays.toString(arr));
  }

  //метод, который преобразует массив в ArrayList
  public static <T> void toList(T[] arr)
  {
    ArrayList<T> result = new ArrayList<>(Arrays.asList(arr));
    System.out.println("Полученный ArrayList: " + result);
  }

}

