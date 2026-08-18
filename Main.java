
import java.util.*;

public class Main{
    static Deque<int[]> dq;
    public static void main(String[] args) {
        dq = new ArrayDeque<>();
        int[] arr = {2,3,4,6,3,8,9,1};
        for(int i:arr){
           push(i); 
        }System.out.println(
    dq.stream()
      .map(Arrays::toString)
      .toList()
);
        System.out.println(getMin());System.out.println(
    dq.stream()
      .map(Arrays::toString)
      .toList()
);
        dq.pop();
        System.out.println(getMin());
        }
    static void push(int ele){
        int newmin = (dq.isEmpty())?ele:Math.min(ele,dq.peek()[1]);
        dq.push(new int[]{ele,newmin});
    }
    static void pop(){
       dq.pop(); 
    }
    static int top(){
        return dq.peek()[0];
    }
    static int getMin(){
        return dq.peek()[1];
    }

    }

