import java.util.*;

public class Rhombus{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    //first regular pyramid
    for(int i=0;i<size;i++){
      for (int s = i; s < size-1; s++) {
       System.out.print(" "); 
      }
      for(int j=0;j<i*2+1;j++){
        System.out.print("*");
      }
      for (int s = i; s < size-1; s++) {
       System.out.print(" "); 
      }
      System.out.println();
    }
    //second inverted pyramid
    for(int i=0;i<size;i++){
      for (int s = 0; s < i; s++) {
       System.out.print(" "); 
      }
      for(int j=0;j<(size-i)*2-1;j++){
        System.out.print("*");
      }
      for (int s = 0; s < i; s++) {
       System.out.print(" "); 
      }
      System.out.println();
    }
  }
}
