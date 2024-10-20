package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterFactory {

    private static final Set<Character> baseDelimiters = Set.of(',', ':');

    public static Set<Character> getBaseDelimiters() {
        return baseDelimiters;
    }

    public static int findFirstIndexAfterDelimiters(String input) {
        int index = 0;

        while (input.startsWith("//", index)) {
            int newlineIndex = input.indexOf("\\n", index);
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }
            index = newlineIndex + 2;
        }

        return index;
    }

    public static Set<Character> createDelimiters(String input) {
        Set<Character> delimiters = new HashSet<>(baseDelimiters);
        String remainingInput = input;

        while (remainingInput.startsWith("//")) {
            int newlineIndex = remainingInput.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }

            String delimiterPart = remainingInput.substring(2, newlineIndex);
            if (delimiterPart.length() != 1) {
                throw new IllegalArgumentException("Invalid custom delimiter length. Only one character is allowed.");
            }

            delimiters.add(delimiterPart.charAt(0));
            remainingInput = remainingInput.substring(newlineIndex + 2);
        }

        return delimiters;
    }
}
