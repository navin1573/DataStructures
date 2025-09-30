import java.util.*;
import java.io.*;

public class LeftTriangleNumber2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
         for(int i=1;i<=size;i++ ){
           for(int j=1;j<=i;j++){
             System.out.print(i);
           }
           System.out.println();
         }  
              
        sc.close();
    }
}
