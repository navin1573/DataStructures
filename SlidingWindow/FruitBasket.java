import java.util.*;

public class FruitBasket {
  
    public static int totalFruit(int[] fruits) {
        Set<Integer> hs = new HashSet<>();
        int s=0;
        int max = 0;
        for(int e=0;e<fruits.length;e++){

          hs.add(fruits[e]);
          while(hs.size()>2){
            hs.remove(s++);
          }
          max = Math.max(max,e-s+1);
        }
        return max;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] fruits1 = {1, 2, 3, 2, 2};
        // Expected Output: 4
        System.out.println(totalFruit(fruits1));

        // Test Case 2
        int[] fruits2 = {1, 2, 1};
        // Expected Output: 3
        System.out.println(totalFruit(fruits2));

        // Test Case 3
        int[] fruits3 = {0, 1, 2, 2};
        // Expected Output: 3
        System.out.println(totalFruit(fruits3));

        // Test Case 4
        int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        // Expected Output: 5
        System.out.println(totalFruit(fruits4));
    }
}
