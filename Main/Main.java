import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class Main{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt(); 
    int b = s.nextInt();
   int[] ans =swapXor(a,b);
    System.out.println(Arrays.toString(ans));
  }

  static int[] swapXor(int a,int b){
    a = a^b;
    b = a^b;
    a = a^b;
   return new int[] {a,b}; 
  }
}
