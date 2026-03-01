import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class FiboMemoization {
 public static void main(String[] args) {
   Map<Integer,Integer> cache = new HashMap<>();
   for(int i=0;i<=10;i++)
   System.out.println(memo(i,cache));
 }
 static int memo(int n,Map<Integer,Integer> cache){
   if(n<=1) return n;

   if(cache.containsKey(n))
      return cache.get(n);

   cache.put(n,memo(n-1,cache) + memo(n-2,cache));
   return cache.get(n);
 }
}
