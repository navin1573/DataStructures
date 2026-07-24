import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class FixedSlide {
 public static void main(String[] args) {
  int[] arr = {1,2,3,4,5,6,7,8,9};
  int n = arr.length;
  int k = 2;
  int wsum=0;
  for(int i=0;i<k;i++)
    wsum+=arr[i]; 
 int max = wsum;
 int right=k;
 while(right<n){
    wsum-=arr[right-k];
    wsum+=arr[right++];
    max=Math.max(max,wsum);
 }
 System.out.println(max);
}
}

