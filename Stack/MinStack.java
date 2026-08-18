import java.util.*;

public class MinStack{
    static Deque<int[]> dq;
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

