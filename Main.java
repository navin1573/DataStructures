import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int[][] arr = new int[5][5];
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
          arr[i][j]=s.nextInt();
      }
    }
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        if(arr[i][j]==1){
          System.out.print(Math.abs(2-i)+Math.abs(2-j));
        }
      }
    }
    }
  }
