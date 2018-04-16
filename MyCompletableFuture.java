import java.util.concurrent.CompletableFuture;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class MyCompletableFuture {


  public static void main(String[] args) {

    // List<CompletableFuture<Void>> aList =  
    // Stream.of(1,2,3,4,5,6,7,8,9).map(element -> CompletableFuture.runAsync(() -> {
    //   System.out.println(Thread.currentThread().getName());
    // })).collect(Collectors.toList());
    // System.out.println("running Async");
    // CompletableFuture.allOf(aList.toArray(new CompletableFuture[0])).join();


  //System.out.println("Start");

  List<CompletableFuture<Integer>> bList = Stream.of(1,2,3,4,5,6,7,8).map(element -> CompletableFuture.supplyAsync(() -> {
    System.out.println("Thread from first async " + element + " " +  Thread.currentThread().getName());
    CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
      System.out.println("running inner async " + element + " " + Thread.currentThread().getName());
    });
    System.out.println(Thread.currentThread().getName() + " " + "doing something while runAsync within async");
    cf.join();
    return element;
  })).collect(Collectors.toList());
  System.out.println("main thread run");
   CompletableFuture.allOf(bList.toArray(new CompletableFuture[0])).join();
  }
}