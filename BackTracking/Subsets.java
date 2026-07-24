import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class Subsets{
  public static void main(String[] args) {
  List<List<Integer>> subSet = new ArrayList<>();
  List<Integer> curSet = new ArrayList<>();
   int[] nums = {0,1,2,2};
    helperDup(0,nums,subSet,curSet);
    System.out.println(subSet);
    System.out.println("-------------------");
   int[] nums2 = {0,1,2,2};
   Arrays.sort(nums2);
  List<List<Integer>> subSet2 = new ArrayList<>();
  List<Integer> curSet2 = new ArrayList<>();
    helper2(0,nums2,subSet2,curSet2);
    System.out.println(subSet2);
  }

  static void helperDup(int i,int[] nums,List<List<Integer>> subSet,List<Integer> curSet){
    if(i>=nums.length){
      subSet.add(new ArrayList<>(curSet));
      return;
    }

    curSet.add(nums[i]);
    helperDup(i+1,nums,subSet,curSet);
    curSet.remove(curSet.size()-1);

    helperDup(i+1,nums,subSet,curSet);
  }

  static void helper2(int i,int[] nums,List<List<Integer>> subSet,List<Integer> curSet){
    if(i>=nums.length){
      subSet.add(new ArrayList<>(curSet));
      return;
}
    curSet.add(nums[i]);
    helper2(i+1,nums,subSet,curSet);
    curSet.remove(curSet.size()-1);
    while(i+1<nums.length && nums[i]==nums[i+1])i+=1;
    helper2(i+1,nums,subSet,curSet);

}

}
