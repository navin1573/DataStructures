import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Palindromes {
  static boolean isPalindrome(String s,int st,int ed){
    if(st>=ed) return true;
    return (s.charAt(st)==s.charAt(ed)) && isPalindrome(s,st+1,ed-1);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
      if(isPalindrome(str,0,str.length()-1)){
        System.out.println("True");
      }
      else{
        System.out.println("False");
      }
  } 
}
