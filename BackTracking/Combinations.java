import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Combinations{
  public static void main(String[] args) {
    List<List<Integer>> Comb= new ArrayList<>();
    List<Integer> Cur = new ArrayList<>();
    int n = 5;
    int k = 2;
    helper(1,n,k,Cur,Comb);
    System.out.println(Comb);
  }

  static void helper(int i,int n,int k,List<Integer> Cur,List<List<Integer>> Comb){
    if(Cur.size()==k){
      Comb.add(new ArrayList<>(Cur));
      return;
    }
    if(i>n) return;
    
    Cur.add(i);
    helper(i+1,n,k,Cur,Comb);
    Cur.remove(Cur.size()-1);
    helper(i+1,n,k,Cur,Comb);
  }
}
