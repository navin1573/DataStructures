import java.util.*;

public class Pyramid{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    for(int i=0;i<size;i++){
      for (int s = i; s < size-1; s++) {
       System.out.print("  "); 
      }
      for(int j=0;j<i*2+1;j++){
        System.out.print("* ");
      }
      for (int s = i; s < size-1; s++) {
       System.out.print("  "); 
      }
      System.out.println();
    }
  }
}
