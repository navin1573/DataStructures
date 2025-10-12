//Star


// import java.util.*;
// import java.io.*;
//
// public class ReverseTriangle {
//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         int size = sc.nextInt();
//         for(int i=0;i<size;i++){
//           for(int j=size;j>i;j--){
//             System.out.print("* ");
//           }
//           System.out.println();
//         }
//         sc.close();
//     }
// }

//numbered
import java.util.*;
import java.io.*;

public class Triangle {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i=0;i<size;i++){
          for(int j=1;j<=size-i;j++){
            System.out.print(j+" ");
          }
          System.out.println();
        }
        sc.close();
    }
}


