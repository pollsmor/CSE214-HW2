package applications.arithmetic;

/**
 * This interface defines the structure of any evaluator to be used for evaluation of arithmetic
 * expressions, be it in infix, prefix, or postfix.
 */
public interface Evaluator {
    /**
     * The only method of any class implementing this interface. It evaluates the given
     * arithmetic expression to a decimal number.
     * @param expressionString the given arithmetic expression as a string
     * @return the final computed value of the arithmetic expression
     */
    double evaluate(String expressionString);
}
