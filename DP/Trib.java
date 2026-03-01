import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class Trib {
  private static Map<Integer,Integer> cache = new HashMap<>();
  public static void main(String[] args) {
    System.out.println(trib(12));
  }
  static int trib(int n){
    if(n==0) return 0;
    if(n==1) return 1;
    if(n==2) return 1;

    if(cache.containsKey(n)){
      return cache.get(n); 
    }
    cache.put(n,trib(n-1)+trib(n-2)+trib(n-3));
    return cache.get(n);
  }
}
