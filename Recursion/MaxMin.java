import java.util.*;

public class MaxMin{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    int[] ans = {Integer.MAX_VALUE,Integer.MIN_VALUE};
    rec(arr,ans,0);
    System.out.println(Arrays.toString(ans));
  }
  static void rec(int[] arr,int[] ans,int st){
     if(st==arr.length){
         return;
     }
     ans[0] = Math.min(ans[0],arr[st]);
     ans[1] = Math.max(ans[1],arr[st]);
     rec(arr,ans,st+1);
  }
}
