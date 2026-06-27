import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class JavaSort {
 public static void main(String[] args) {
  int[][] arr = {
    {6,1},
    {3,3},
    {2,5}
  };

  Arrays.sort(arr,(x,y)->x[1]-y[1]);
  System.out.println(Arrays.deepToString(arr));
 } 
}
