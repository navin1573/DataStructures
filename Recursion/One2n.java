import java.util.*;

public class One2n {
 public static void main(String[] args) {
   System.out.println(rec(5));
 }
 static int rec(int i,int n){
    if(i>n) return 0;
    System.out.println(i+" ");
    return rec(i+1,5);
 }
}
