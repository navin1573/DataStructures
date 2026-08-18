import java.util.*;

public class TwoStackQueue{
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    // Add element
    static void push(int newElement) {

        s1.push(newElement);
    }

    // Remove element
    static int pop() {

        // Transfer s1 -> s2 if s2 is empty
        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {

                int element = s1.pop();

                s2.push(element);
            }
        }

        int removeElement = s2.peek();
        s2.pop();

        return removeElement;
    }
    static int peek(){
        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {

                int element = s1.pop();
                s2.push(element);
            }
        }
        if(s2.isEmpty()) return -1;
        return s2.peek();
    }
    // Find minimum
    static int getMin() {

        if (s1.isEmpty() && s2.isEmpty())
            return -1;

        if (s1.isEmpty())
            return s2.peek();

        if (s2.isEmpty())
            return s1.peek();

        return Math.min(s1.peek(), s2.peek());
    }

    static boolean empty(){
        if(s2.isEmpty() && s1.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args) {
         push(10);
         push(20);
         push(30);
         push(40);
         push(50);
         push(3);
         push(7);
         push(2);
         push(6);

        System.out.println(q.pop());    // 5
        System.out.println(q.pop());    // 3
        System.out.println(s1);
        System.out.println(s1);

    }
}
