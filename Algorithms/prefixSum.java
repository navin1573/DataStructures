import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class prefixSum{
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int s = sc.nextInt();
  int[] arr = new int[s];

  for (int i = 0; i < s; i++) {
     arr[i]=sc.nextInt(); 
    }
    int i =sc.nextInt();
    int j =sc.nextInt();

    // precomputing prefix sum
    int prefix[] = new int[s];
    prefix[0]=arr[0];
    for(int k=1;k<s;k++){
      prefix[k]=arr[k]+prefix[k-1];
    }
    int ans = rangeQuery(i,j,prefix);
    System.out.println(ans);
    

  }
    static int rangeQuery(int l,int r,int[] prefix){
      return (l==0)?prefix[r]:prefix[r]-prefix[l-1];
    }
}
