import java.util.*;
public class BinarySearch {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
       int tar = sc.nextInt();
       System.out.println(rec(arr,0,n-1,tar));
   }
   static int rec(int[] arr,int s,int e,int tar){
    if(s>e){
        return -1;
    }
    int mid = s +((e-s)>>1);
    if(arr[mid]==tar){
        return mid;
    }
    else if(arr[mid]<tar){
        return rec(arr,mid+1,e,tar);
    }
    else{
        return rec(arr,s,mid-1,tar);
    }
   }
}
