import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class Subsets{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr= new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    List<List<Integer>> ans  = new ArrayList<>();
    subset(ans,new ArrayList<>(),0,arr);
      for(List<Integer> i:ans){
        System.out.println(i);
      }
}
static void subset(List<List<Integer>> ans,List<Integer> sub,int st,int[] arr){
  if(st==arr.length){
    ans.add(new ArrayList<>(sub));
    return;
  }
   // dont take
   subset(ans,sub,st+1,arr);
   //take
   sub.add(arr[st]);
   subset(ans,sub,st+1,arr);
   sub.remove(sub.size()-1); 
}

}
