package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * This class is used for converting an expression string in infix notation to that of postfix
 * notation, for easier evaluation.
 *
 * @author Kevin Li
 */
public class ToPostfixConverter implements Converter {
    /**
     * The fundamental method of this class, which converts an arithmetic expression from infix to postfix notation.
     *
     * @param expression  the given arithmetic expression
     * @return the given arithmetic expression, converted into postfix notation
     */
    public String convert(ArithmeticExpression expression) {
        StringBuilder exp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String s = expression.getExpression();

        int i = 0;
        while (i < s.length()) {
            String token = nextToken(s, i);
            if (isOperand(token)) {
                exp.append(token);
                exp.append(" ");
            } else if (Brackets.isLeftBracket(token)) stack.push(token);
            else if (Brackets.isRightBracket(token)) {
                while (!stack.isEmpty() && !Brackets.isLeftBracket(stack.peek())) {
                    exp.append(stack.pop()); // keep adding symbols to expression
                    exp.append(" ");
                }

                 stack.pop(); // left parenthesis remains, simply pop
            } else { // is an operator
                while (!stack.isEmpty() && Operator.of(token).getRank() >= Operator.of(stack.peek()).getRank()) {
                    exp.append(stack.pop());
                    exp.append(" ");
                }

                stack.push(token); // higher precedence or stack is empty
            }

            i += token.length();
        }

        while (!stack.isEmpty()) {
            exp.append(stack.pop()); // step 7
            exp.append(" ");
        }

        return exp.toString();
    }


    /**
     * Given a string and a specific index, this method returns the next token starting at that index.
     * This function assumes whatever uses it will call it only at the start of a token.
     *
     * @param s     the given string
     * @param start the given index
     * @return the next token starting at the given index in the given string
     */
    public String nextToken(String s, int start) {
        String charAtIdx = s.substring(start, start + 1);
        if (!isOperand(charAtIdx)) return charAtIdx; // operators and parens can be 1 character long only so just return

        TokenBuilder token = new TokenBuilder(); // is a number, might be more than 1 character long
        while (start < s.length() && isOperand(charAtIdx)) {
            token.append(charAtIdx.charAt(0)); // 1 character string anyway
            start++;
            if (start < s.length()) // prevent index out of bounds
                charAtIdx = s.substring(start, start + 1); // set character to next in the string
        }

        return token.build();
    }

    /**
     * Determines whether or not a string is a valid operand.
     *
     * @param s the given string
     * @return <code>true</code> if the given string is a valid operand, and <code>false</code> otherwise
     */
    public boolean isOperand(String s) {
        return !Operator.isOperator(s) &&
               !Brackets.isLeftBracket(s) &&
               !Brackets.isRightBracket(s);
    }
}
