package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<Character> delimiters;
    private static final char[] defaultDelimiters = new char[] {':', ','};

    public Delimiter() {
        delimiters = new ArrayList<>();
    }

    public int getSkipSize() {
        return delimiters.size() == 1 ? 5 : 0;
    }

    public void calculateDelimiters(String input) {
        if (5 <= input.length() && checkDelimiter(input)) {
            delimiters.add(input.charAt(2));
        } else {
            setDefaultDelimiters();
        }
    }

    private boolean checkDelimiter(String input) {
        return input.charAt(0) == '/'
                && input.charAt(1) == '/'
                && input.charAt(3) == '\\'
                && input.charAt(4) == 'n';
    }

    private void setDefaultDelimiters() {
        for (char delimiter: defaultDelimiters) {
            delimiters.add(delimiter);
        }
    }


    public boolean contains(char c) {
        for (Character delimiter: delimiters) {
            if (delimiter.equals(c))
                return true;
        }

        return false;
    }
}
