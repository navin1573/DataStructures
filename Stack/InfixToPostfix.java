import java.util.*;

public class InfixToPostfix{

    // Returns precedence of operators (higher number = higher priority)
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch); // directly add operands
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop(); // remove '('
            }
            else { // operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        System.out.println(infixToPostfix(input));
    }
}
