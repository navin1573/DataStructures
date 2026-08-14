import java.util.*;
public class ProductOfTwo{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int ans=rec(x,y);
    System.out.println(ans);
   }
   static int rec(int x,int y){
        
     if(y==0) return 0;
     
     return x + rec(x,y-1);
   }
}
