import java.util.*;
public class GeekonaciNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
      System.out.println(rec(A,B,C,N));
    }
    static int rec(int A,int B,int C,int N){
        if(N==A) return A;
        if(N==B) return B;
        if(N==C) return C;

        return rec(A,B,C,N-1)+rec(A,B,C,N-2)+rec(A,B,C,N-3);
 }
}
