import java.util.*;
public class sumOfNumbers {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
  int sum=recSum(n);
  System.out.println(sum);
 }
 static int recSum(int n){
   if(n==0) return 0;
    return n+recSum(n-1);
 }
}
