import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class LongestUnique {
 public static void main(String[] args) {
 StringBuilder sb = new StringBuilder("abcdefghij");
 Set<Character> hs = new HashSet<>();
  int left =0;
  int ans=0;
  for(int right=0;right<sb.length();right++){
      char ch = sb.charAt(right);
      while(hs.contains(ch)){
        hs.remove(sb.charAt(left++));
      }
      hs.add(ch);
      ans = Math.max(ans,right-left+1);
  }
  System.out.print(ans);
 } 
}
