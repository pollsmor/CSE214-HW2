package applications.arithmetic;

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

    private static boolean isDyckWord(String word) {
        return true;
    }

    public String getWord() {
        return word;
    }

}
