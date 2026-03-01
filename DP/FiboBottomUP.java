import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class FiboBottomUP{
  public static void main(String[] args) {
   fibo(10); 
  }
  static int fibo(int n){
    if(n<2){
      System.out.println(n);
      return n;
    }
    int[] dp = {0,1};
    int i=2;
    while(i<=n){
      int temp = dp[1];
      dp[1] = dp[0]+dp[1];
      System.out.println(dp[1]);
      dp[0] = temp; 
      i++;
    }
    return dp[1];
  }
}
