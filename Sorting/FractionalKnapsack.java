import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class FractionalKnapsack {
public static void main(String[] args) {
  int[] val = {10,10,10,100};
  int[] wt = {10,10,10,30};
  int cap = 30;
  int[][] ansArr = new int[val.length][2];
  for(int i=0;i<val.length;i++){
    ansArr[i][0] = val[i]; 
    ansArr[i][1] = wt[i];
  }
  Arrays.sort(ansArr,(a,b)->Double.compare(1.0*b[0]/b[1],1.0*a[0]/a[1]));
  double ans = 0.0;
  int curCap = cap;
      for(int i=0;i<val.length;i++){
         if(ansArr[i][1]<=curCap){
           ans+=ansArr[i][0];
           curCap-=ansArr[i][1];
         }
         else{
           ans+=((double)curCap/ansArr[i][1])*ansArr[i][0];
           break;
         }
      }
    System.out.println(ans);
} 
}
