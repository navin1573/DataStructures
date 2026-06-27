import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class MergeOverlapping {
 public static void main(String[] args) {
  int[][] arr = {
    {7,8},
    {1,5},
    {2,4},
    {4,6}
  };

  Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
  ArrayList<int[]> ans = new ArrayList<>();
  ans.add(new int[] {arr[0][0],arr[0][1]});
  for(int i=1;i<arr.length;i++){
    int[] las = ans.get(ans.size()-1);
    int[] cur = arr[i];
    if(cur[0]<=las[1]){
        las[1]=Math.max(las[1],cur[1]);
    }
    else{
      ans.add(new int[] {cur[0],cur[1]});
    }
  }
  for(int[] ar : ans){
      System.out.print("["+ar[0]+","+ar[1]+"]");
  }
  }
  }
