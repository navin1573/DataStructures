import java.util.*;
import java.io.*;

public class OneZero {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i=0;i<size;i++){
          for(int j=0;j<i+1;j++){
            System.out.print(((i+j)%2==0)?"1":"0");
          }
          System.out.println();
        }
    }
}
