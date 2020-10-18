package applications.arithmetic;

public class ToPostfixConverter implements Converter {
    public String convert(ArithmeticExpression expression) {
        return "";
    }

    public String nextToken(String s, int start) {
        return "";
    }

    public boolean isOperand(String s) {
        return true;
    }
}
