import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class removeDuplicatesSorted {
  public static int Solution(int[] arr) {
   int nonduplicate = 1;
   for (int i = 0; i < arr.length; i++) {
    if(arr[nonduplicate-1]!=arr[i]){
      arr[nonduplicate] = arr[i];
      nonduplicate++;
    }
   }
   return nonduplicate;
  }
 public static void main(String[] args) {
  int[] arr = {2,2,3,4,6,7,8,8,9,9,10};
  System.out.println(removeDuplicatesSorted.Solution(arr));
  arr = new int[] { 2,2,2,11};
  System.out.println(removeDuplicatesSorted.Solution(arr));
 } 
}
