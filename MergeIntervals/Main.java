import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[][] arr = new int[size][2];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < 2; j++) {
       arr[i][j]=sc.nextInt(); 
      } 
    }
    System.out.println("before sort");
    System.out.println(Arrays.deepToString(arr));

    Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
    System.out.println("first num ascending");
    System.out.println(Arrays.deepToString(arr));

    Arrays.sort(arr,(a,b) -> Integer.compare(b[0],a[0]));
    System.out.println("first num descending");
    System.out.println(Arrays.deepToString(arr));

    Arrays.sort(arr,(a,b) -> Integer.compare(a[1],b[1]));
    System.out.println("second num ascending");
    System.out.println(Arrays.deepToString(arr));

    Arrays.sort(arr,(a,b) -> Integer.compare(b[1],a[1]));
    System.out.println("second num desending");
    System.out.println(Arrays.deepToString(arr));
 } 
}
