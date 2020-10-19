package applications.arithmetic;

import datastructures.sequential.Stack;

public class ToPostfixConverter implements Converter {
    public String convert(ArithmeticExpression expression) {
        return nextToken("1+2+3+45+83151.0+10", 6);
    }

    // This function assumes whatever uses it will call it only at the start of a token.
    public String nextToken(String s, int start) {
        String charAtIdx = s.substring(start, start + 1);
        if (!isOperand(charAtIdx)) return charAtIdx; // operators can be 1 character long only so just return

        TokenBuilder token = new TokenBuilder(); // is a number, might be more than 1 character long
        while (start < s.length() && isOperand(charAtIdx)) {
            token.append(charAtIdx.charAt(0)); // 1 character string anyway
            start++;
            charAtIdx = s.substring(start, start + 1); // set character to next in the string
        }

        return token.build();
    }

    public boolean isOperand(String s) {
        return !Operator.isOperator(s) &&
               !Brackets.isLeftBracket(s) &&
               !Brackets.isRightBracket(s);
    }
}
