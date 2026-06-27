// Sorting + greedy
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class ActivitySelection{
  public static void main(String[] args) {
        int[] s= {1, 3, 0, 5, 8, 5};
        int[] e= {2, 4, 6, 7, 9, 9};
    int l = s.length;
    int[][] ansArr = new int[l][2];
    for(int i=0;i<l;i++){
      ansArr[i][0] = s[i];
      ansArr[i][1] = e[i];
    }
    Arrays.sort(ansArr,(x,y)->x[1]-y[1]);
    int ans=0;
    int endTime = Integer.MIN_VALUE;
    for(int i=0;i<l;i++){
        if(ansArr[i][0]>=endTime){
            ans++;
            endTime = ansArr[i][1];
        }
    }
    System.out.println("ANS: "+ ans); 
  }
}
