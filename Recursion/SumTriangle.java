import java.util.*;

public class SumTriangle{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    rec(arr);
  }
  static void rec(int[] arr){
        if(arr.length<=1){
            return;
        }
        int[] temp = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            int x=arr[i]+arr[i+1];
            temp[i]=x;
        }
       rec(temp);
       System.out.println(Arrays.toString(temp));
  }
}
