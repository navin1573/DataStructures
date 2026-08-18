import java.util.*;

class MinQueue3{
    static Deque<Integer> q = new ArrayDeque<>();

    // Add
    static void push(int x) {
        while (!q.isEmpty() && q.peekLast() > x) {
            q.pollLast();
        }

        q.offerLast(x);
    }

    // Remove: must know the actual element
    static void pop(int removeElement) {
        if (!q.isEmpty() && q.peekFirst() == removeElement) {
            q.pollFirst();
        }
    }

    // Minimum
    static int getMin() {
        return q.peekFirst();
    }
}
