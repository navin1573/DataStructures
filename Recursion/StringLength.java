import java.util.*;
public class StringLength{
    public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          String s = sc.next();
          int ans =rec(s);
          System.out.println(ans);
    }
    static int rec(String s){
        if(s=="") return 0;
        return rec(s.substring(1))+1; 
    }

}
