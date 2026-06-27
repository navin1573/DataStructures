import java.util.*;

public class sumOfNumbers {
 public static void main(String[] args) {
 int sum=recSum(10);
 System.out.println(sum);
 }
 static int recSum(int n){
   if(n==0) return 0;
    return n+recSum(n-1);
 }
}
