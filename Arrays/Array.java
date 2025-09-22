import java.util.*;

public class Array{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter array size: ");
    int size = s.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      System.out.println("Enter number " + (i+1)+": ");
      arr[i] = s.nextInt();
    }
    System.out.println(Arrays.toString(arr));
  }

}
