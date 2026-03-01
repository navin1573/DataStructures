import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class NaiveSort {
 public static void main(String[] args) {
  int[] arr = {1,4,6,8,3,1,4,8};
  naiveSort(arr,arr.length);
  System.out.println(Arrays.toString(arr));
 }
 static void naiveSort(int[] arr,int n){
   for(int i=0;i<n-1;i++){
     for(int j=i+1;j<n;j++){
       if(arr[i]>arr[j]){
         swap(arr,i,j);
     }
   }
  }
}
 static void swap(int[] arr,int a,int b){
   int temp = arr[a];
   arr[a] = arr[b];
   arr[b] = temp;
 }

 }
