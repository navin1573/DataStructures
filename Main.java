import java.util.*;
 public class Main {
  public static void main(String[] args) {
    Set<Integer> ts = new TreeSet<Integer>();
    ts.add(10);
    ts.add(90);
    ts.add(20);
    ts.add(90);
    ts.add(1);
    ts.add(34);
    ts.add(45);
    for (Integer num : ts) {
     System.out.print(num+" "); 
    }
 }
 }
