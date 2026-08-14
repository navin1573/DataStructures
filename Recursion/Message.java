import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Message {
   public static void main(String[] args) {
        message(5);
   }
   static void message(int i){
       if(i==0) return;
       System.out.println("Hello"+ i);
       message(i-1);
}
}
