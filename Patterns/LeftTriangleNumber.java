import java.util.*;
import java.io.*;

public class LeftTriangleNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
         for(int i=0;i<size;i++ ){
           for(int j=1;j<=i+1;j++){
             System.out.print(j);
           }
           System.out.println();
         }  
              
        sc.close();
    }
}
