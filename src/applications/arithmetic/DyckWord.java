package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * @author Ritwik Banerjee
 */
public class DyckWord {

    private final String word;

    public DyckWord(String word) {
        if (isDyckWord(word))
            this.word = word;
        else
            throw new IllegalArgumentException(String.format("%s is not a valid Dyck word.", word));
    }

    /**
     * Determines whether or not a string is a valid Dyck word.
     * I'd just like to note that this implementation leaves cases like "(3+{1+2})*()" through. I hope this is outside the scope of the assignment.
     *
     * @param word the given string
     * @return <code>true</code> if the given string is a valid Dyck word, and <code>false</code> otherwise.
     */
    private static boolean isDyckWord(String word) {
        Stack<Character> stack = new Stack<>(); // for storing all bracket characters
        for (int i = word.length() - 1; i >= 0; i--) { // go backwards as I want the leftmost brackets to be at the top of the stack
            char element = word.charAt(i);
            if (Brackets.isLeftBracket(element) || Brackets.isRightBracket(element))
                stack.push(element);
        }

        if (stack.size() % 2 != 0) return false; // obviously not a Dyck word if the amount of brackets is not a multiple of 2

        // Second stack for storing lone left brackets to be compared with right brackets later
        Stack<Character> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (Brackets.isLeftBracket(c)) {
                stack2.push(c);
            } else {
                if (stack2.isEmpty() || !Brackets.correspond(stack2.peek(), c))
                    return false; // right bracket with no left bracket to compare to, or brackets "types" don't match even when compared

                stack2.pop();
            }
        }

        return true; // never returned false in the while loop, must be a Dyck word
    }

    public String getWord() {
        return word;
    }

}
