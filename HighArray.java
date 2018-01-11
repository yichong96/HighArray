public class HighArray {

  private long[] array;
  int numElems;

  public HighArray(int max) {
    this.numElems = 0;
    this.array = new long[max];
  }

  public int size() {
    return numElems;
  }


  public boolean find(long searchKey) {
    int j = 0;
    for (j = 0; j < numElems; j++) {
      if (array[j] == searchKey) {
        return true;
      }
    }
    return false;
  }


  public void insert(long value) {
    this.array[numElems] = value;
    numElems++;
  }

  public boolean delete(long value) {
    int j;
    for (j = 0; j < numElems; j++) {
      if (array[j] == value) {
        break;
      }
    }
    if (j == numElems) {
      return false;
    }
    for (int k = j; k < numElems; k++) {
      array[k] = array[k + 1];
    }
    numElems--;
    return true;
  }


  public void display() {
    for (int j = 0; j < numElems; j++) {
      System.out.print(array[j] + " ");
    }
    System.out.println(" ");
  }

  public long removeMax() {
    if (numElems == 0) {
      return -1;
    } else {
      long max = -1;
      for (int i = 0; i < numElems; i++) {
        if (array[i] > max) {
          max = array[i];
        }
      }
      delete(max);
      return max;
    }
  }


  public void removeDups() {
    for (int i = 0; i < numElems; i++) {
      for (int j = i+1; j < numElems; j++) {
        if (array[i] == array[j]) {
          array[j] = -1;
        }
      }
    }
    while (find(-1)) {
      delete(-1);
    }
  }

  public void swap(int index1,int index2) {
    long temp = array[index2];
    array[index2] = array[index1];
    array[index1] = temp;
  }

  public void bubbleSort() {
    for (int i = numElems - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j+1] < array[j]) {
          swap(j,j+1);
        }
      }
    }
  }

  public void selectionSort() {
    for (int i = 0; i < numElems - 1; i++) {
      int min = i;
      for (int j = i + 1; j < numElems; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      swap(min,i);
      //display();
    }
  }

  public void insertionSort() {
    long innerCount = 0;
    for (int i = 1; i < numElems; i++) {
      int marker = i;
      long markerVal = array[i];
      while (marker > 0 && array[marker - 1] > markerVal) {
        array[marker] = array[marker - 1];
        marker--;
        innerCount++;
      }
      array[marker] = markerVal;
      //display();
    }
    System.out.printf("%d \n" ,innerCount);
  }

  public void insertionSortAndRemoveDups() {
    int count = 0;
    for (int i = 1; i < numElems; i++) {
      int marker = i;
      long markerVal = array[i];
      while (marker > 0 && array[marker - 1] >= markerVal) {
        if (array[marker - 1] == markerVal && markerVal != -1) {
          markerVal = -1;
          count++;
        }
        array[marker] = array[marker - 1];
        marker--;
      }
      array[marker] = markerVal;
      //display();
    }
    for (int j = count; j < numElems; j++) {
      array[j-count] = array[j];
    }
    numElems -= count;
  }

  public void removeDupsSorted() {
    int count = 0;
    for (int i = 0; i < numElems - 1; i++) {
      if (array[i] == array[i+1]) {
        count++;
      } else {
        array[i-count] = array[i];
      }
    }
    array[numElems - 1 - count] = array[numElems - 1];
    numElems = numElems - count;
  }

  public long median() {
    // if odd index
    insertionSort();
    if (numElems % 2 == 0) {
      return (array[((numElems - 1 )/ 2)] + array[(((numElems - 1) / 2)) +
          1])/2;
    } else {
      return array[(numElems - 1)/2];
    }
  }

  public void oddEvenSort() {
    int numOddSwaps = numElems % 2 == 0 ? numElems / 2 : (numElems / 2 ) + 1;
    int count = 0;
    while (count != numOddSwaps) {
      for (int i = 1; i + 1 < numElems; i = i + 2) {
        if (array[i+1] < array[i]) {
          swap(i,i+1);
        }
      }
      for (int j = 0; j + 1< numElems; j = j + 2) {
        if (array[j + 1] < array[j] && j + 1 < numElems) {
          swap(j,j+1);
        }
      }
      count++;
    }
  }

}

