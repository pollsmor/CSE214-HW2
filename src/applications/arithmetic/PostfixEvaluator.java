package applications.arithmetic;

import datastructures.sequential.Stack;

public class PostfixEvaluator implements Evaluator {
    public double evaluate(String expressionString) {
        ToPostfixConverter converter = new ToPostfixConverter();
        String[] elements = expressionString.split(" "); // split all the elements into an array
        Stack<String> stack = new Stack<>();
        for (String el : elements) {
            if (converter.isOperand(el)) stack.push(el);
            else {
                double val1 = Double.parseDouble(stack.pop());
                double val2 = Double.parseDouble(stack.pop());

                switch (el.charAt(0)) {
                    case '+' -> stack.push("" + (val2 + val1)); // convert back to String with the ""
                    case '-' -> stack.push("" + (val2 - val1));
                    case '*' -> stack.push("" + (val2 * val1));
                    case '/' -> stack.push("" + (val2 / val1));
                    // reminder: val2 is technically to the left
                }
            }
        }

        return Double.parseDouble(stack.pop());
    }
}
