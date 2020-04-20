import java.util.ArrayList;

public class RemoveDuplicates
{
  static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
  {
    for(int i = 0; i < list.size(); i++)
    {
        for(int j = i+1; j < list.size(); j++)
        {
          if(list.get(i).equals(list.get(j)))
              list.remove(j);
        }
    }
    return list;
  }
  public static void main(String[] args)
  {
    ArrayList<Integer> arrayOfDuplicates = new ArrayList<>();

    for(int i = 0; i < 10; i++) {
      int number = i/2;
      arrayOfDuplicates.add(number);
    }

    arrayOfDuplicates = removeDuplicates(arrayOfDuplicates);
    for(Integer i : arrayOfDuplicates)
      System.out.println(i);
  }
}