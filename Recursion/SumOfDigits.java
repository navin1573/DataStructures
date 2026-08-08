import java.util.*;
public class SumOfDigits {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans=rec(n);
    System.out.println(ans);
   }
   static int rec(int n){
     if(n==0) return 0;
     
     return n%10+rec(n/10);
   }
}
