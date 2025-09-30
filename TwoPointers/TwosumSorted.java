import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class TwosumSorted {
 public static int[] Solution(int[] arr, int target) {
  int i=0;
  int j=arr.length-1;
  while(i <= j){
    if(target==arr[i]+arr[j]){ return new int[] {arr[i],arr[j]}; }
    else if(target>arr[i]+arr[j]){
      i++;
    }
    else{
      j--;
    }
  }
  return new int[] {0,0};
 }



public static void main(String[] args) {
 int[] result = TwosumSorted.Solution(new int[] {1,2,3,4,5,6},6);

 System.out.println(Arrays.toString(result));

 result = TwosumSorted.Solution(new int[] {2,5,9,11},11);

 System.out.println(Arrays.toString(result));

}

}
