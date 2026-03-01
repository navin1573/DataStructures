import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class BubbleSort {
 public static void main(String[] args) {
  int[] arr = {5,7,8,3,5,2,1};
  bubbleSort(arr,arr.length);
  System.out.println(Arrays.toString(arr));
 } 
 static void bubbleSort(int[] arr, int n){
    for(int i=0;i<n-1;i++){
      for(int j=0;j<n-i-1;j++){
        if(arr[j]>arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
 }
}
