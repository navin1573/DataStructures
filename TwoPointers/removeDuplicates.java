import java.util.*;

public class RemoveDuplicates{
  static int dup(int[] arr){
    int nextdupp=1;
    for(int i=1;i<arr.length;i++){
      if(arr[nextdupp-1]!=arr[i]){
        arr[nextdupp] = arr[i];
        nextdupp++;
      }
    }
    return nextdupp;
  }
public static void main(String[] args) {
  int[] arr = {2,6,3,3,3,9,9};
  System.out.println(dup(arr));
}
}

