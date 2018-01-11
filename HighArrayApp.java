import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;

public class HighArrayApp {

  public static void main(String[] args) {
    HighArray ha = new HighArray(20);
    ha.insert(10);
    ha.insert(20);
    ha.insert(13);
    ha.insert(21);
    ha.insert(98);
    ha.insert(74);

    //ha.display();
    ha.removeMax();
    ha.delete(10);
    ha.delete(21);
    ha.delete(74);


    //ha.display();

    ha.insert(20);
    ha.insert(84);
    ha.insert(13);
    ha.insert(90);
    ha.insert(13);
    ha.display();

    ha.insertionSortAndRemoveDups();
    ha.display();

    //displaySortTimes(HighArray::insertionSort);
//    displaySortTimes(HighArray::selectionSort);
//    displaySortTimes(HighArray::bubbleSort);
    //ha.removeDupsSorted();
    //ha.display();
    //System.out.print(ha.median());
  }


  public static void displaySortTimes(Consumer<HighArray>
                                          sortingAlgorithm) {
    HighArray ha = new HighArray(1000000);
    for (int j = 0; j < 500000; j++) {
      //long n = (long)(java.lang.Math.random()*(100000 - 1));
      ha.insert(j);
    }
    Instant start = Instant.now();
    sortingAlgorithm.accept(ha);
    Instant end = Instant.now();
    System.out.println(Duration.between(start,end).toMillis());
  }
}
