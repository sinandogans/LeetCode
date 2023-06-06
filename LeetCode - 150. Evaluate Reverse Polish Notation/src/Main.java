import java.util.Stack;

public class Main {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        int operand2;
        int operand1;
        for (String token : tokens) {
            switch (token) {
                case "*" -> {
                    operand2 = operands.pop();
                    operand1 = operands.pop();
                    operands.push(operand1 * operand2);
                }
                case "/" -> {
                    operand2 = operands.pop();
                    operand1 = operands.pop();
                    operands.push(operand1 / operand2);
                }
                case "+" -> {
                    operand2 = operands.pop();
                    operand1 = operands.pop();
                    operands.push(operand1 + operand2);
                }
                case "-" -> {
                    operand2 = operands.pop();
                    operand1 = operands.pop();
                    operands.push(operand1 - operand2);
                }
                default -> operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int output = evalRPN(tokens);
        System.out.println(output);
    }
}