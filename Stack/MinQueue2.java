import java.util.*;

public class MinQueue2{
    static Deque<int[]> dq;
    static int cAdd=0;
    static int cRem=0;
    public static void main(String[] args) {
        dq = new ArrayDeque<>();
        int[] arr = {3,4,6,3,2,9,1};
        push(5);
        push(3);
        push(2);
        push(1);
        push(0);
        System.out.println(cAdd);
        System.out.println(cRem);
        System.out.println(dq.stream().map(Arrays::toString).toList());
        }
    static void push(int ele){
        while(!dq.isEmpty() && dq.peek()[0]>ele){
            dq.removeFirst();
            cAdd++;
        }
        dq.addFirst(new int[]{ele,cAdd});
    }
    static void pop(){
    }
    static int top(){
        return 999;
    }
    static int getMin(){
        return 999;
    }

    }

