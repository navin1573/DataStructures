import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Merge{
  public static void main(String[] args) {
    int[] arr = {1,5,7,2,6,9,5,2};
    int s = 0;
    int e = arr.length-1;
    mergeSort(arr,s,e);
    System.out.println(Arrays.toString(arr));
  }
  static void mergeSort(int[] arr,int s,int e){
    if(s>=e) return;
    int mid = s+(e-s)/2;
    mergeSort(arr,s,mid);
    mergeSort(arr,mid+1,e);
    merge(arr,s,mid,e);
  }
  static void merge(int[] arr, int s,int m,int e){
    int n1 = m-s+1;
    int n2 = e-m;
    int[] t1 = new int[n1];
    int[] t2 = new int[n2];
    for(int i=0;i<n1;i++)
      t1[i] = arr[s+i];

    for(int j=0;j<n2;j++)
      t2[j] = arr[m+1+j];

    int i=0,j=0,k=s;
    while(i< n1 && j<n2){
      if(t1[i]<=t2[j]){
        arr[k++] = t1[i++];
      }
      else{
        arr[k++] = t2[j++];
      }
    }
    while(i<n1){
      arr[k++]= t1[i++];
    }
    while(j<n2){
      arr[k++]= t2[j++];
    }
  }
}
