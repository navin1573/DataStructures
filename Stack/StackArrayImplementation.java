import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class StackGG {
  int[] arr = new int[999];
  int top=-1;
  void push(int ele){
    if(!isFull()){
   arr[++top]=ele;
      return;
  }
    System.out.println("Stack Overflow");
  }
  
  void pop(){
    if(!isEmpty()){
  System.out.print("Popped"+ arr[top--]);
    }
    else{
      System.out.println("Stack undeflow");
    }
  }

  void peek(){
    if(isEmpty()){
      System.out.print("Stack underflow");
      return;
    }
   System.out.println(arr[top]);
  }

  boolean isEmpty(){
    if(top==-1){
      return true;
    }
    return false;
  }
  
  boolean isFull(){
    if(top==arr.length-1){
      return true;
    }
    return false;
  }
  void display(){
   for(int i=0;i<=top;i++){
      System.out.print(arr[i] +" ");
    }
  }
  }
public class StackArrayImplementation {
 public static void main(String[] args) {
    StackGG st = new StackGG();
     Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Display Stack");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                     System.out.print("Enter element to Push: ");
                     int ele = sc.nextInt();
                     st.push(ele);
                    break;

                case 2:
                    st.pop();
                    break;

                case 3:
                    st.peek();
                    break;

                case 4:
                    st.isEmpty();
                    break;

                case 5:
                    st.isFull();
                    break;

                case 6:
                    st.display();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
 }
}
