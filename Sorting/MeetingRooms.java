import java.util.*; 
import java.io.*;
import java.lang.*;
import java.math.*;

public class MeetingRooms {
 public static void main(String[] args) {
  int[][] arr = {
    {2,4},
    {9,12},
    {6,10}
  };
  int endTime = Integer.MIN_VALUE;
  Arrays.sort(arr,(a,b)->a[1]-b[1]); // can use Integer.compare(a[1],b[1]); instead of lalmbda
  for(int i=0;i<arr.length;i++){
    if((arr[i][0]<endTime)){
      System.out.println("false");
      return;
    }
    endTime=arr[i][1];
  }
  System.out.println("true");
 } 
}
