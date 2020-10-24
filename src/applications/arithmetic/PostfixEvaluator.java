package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * This class is an implementation of the Evaluator interface, specifically used for evaluating
 * expression strings in postfix notation.
 *
 * @author Kevin Li
 */
public class PostfixEvaluator implements Evaluator {
    /**
     * Given a postfix expression, this method computes and returns the result.
     *
     * @param expressionString the given arithmetic expression as a string, in postfix notation
     * @return the final computed value of the arithmetic expression
     */
    public double evaluate(String expressionString) {
        if (expressionString.equals("")) return 0; // edge case where infix expression is ()
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
