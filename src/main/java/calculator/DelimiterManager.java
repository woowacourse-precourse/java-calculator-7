package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterManager {
    private final Set<Character> delimiters = new HashSet<>();

    DelimiterManager() {}

    DelimiterManager(char... delimiters) {
        for (char delimiter : delimiters) {
            this.delimiters.add(delimiter);
        }
    }

    public void add(char delimiter) {
        delimiters.add(delimiter);
    }
}
