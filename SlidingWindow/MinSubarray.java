import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class MinSubarray {
  public static void main(String[] args) {
    int[] nums = {2,3,1,2,5,};
    int target = 7;
    int left =0;
    int ans = Integer.MAX_VALUE;
    int sum=0;
    for(int right =0;right<nums.length;right++){
        sum+=nums[right];

        while(sum>=target){
          ans = Math.min(ans,right-left+1);
          sum-=nums[left++];
        }
    }
    System.out.println((ans==Integer.MAX_VALUE)?0:ans);
  }
}
