import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class removeDuplicates {
  public static int Solution(int[] arr,int key) {
   int nextElement = 0;
   for (int i = 0; i < arr.length; i++) {
     if(arr[i]!=key){
       arr[nextElement] = arr[i];
       nextElement++;
     } 
   }
   System.out.println(Arrays.toString(arr));
   return nextElement;
  }
  
  
 public static void main(String[] args) {
  int ans = removeDuplicates.Solution(new int[] {3,2,3,6,3,10,9,3},3);
  System.out.println(ans);
  // 3, 2, 3, 6, 3, 10, 9, 3 (3)
  // 2, 11, 2, 2, 1 (2) 
   ans = removeDuplicates.Solution(new int[] {2,11,2,2,1},2);
  System.out.println(ans);
  } 
}
