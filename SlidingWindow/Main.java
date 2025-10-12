import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    int maxSum = Integer.MIN_VALUE;
    int[] arr ={2, 1, 5, 1, 3, 2};
    int k = 3;
    for(int i=0;i<arr.length-k;i++){
      int sum = 0;
      for (int j = i; j < i+k; j++) {
        sum+=arr[i][j];
      }
      maxSum = Math.max(maxSum,sum);

    }
  } 
}
