import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {2,8,5,3,8,9};
    selectionSort(arr,arr.length);
    System.out.println(Arrays.toString(arr));
  }
  static void selectionSort(int[] arr,int n){
    for(int i=0;i<n-1;i++){
      int minidx = i;
      for(int j=i+1;j<n;j++){
        if(arr[j]<arr[minidx]){
          minidx=j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[minidx];
      arr[minidx] = temp;
    }
  }
  
}
