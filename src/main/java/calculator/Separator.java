package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private String string;
    private final List<Character> separators;

    public Separator(String string) {
        this.string = string;
        separators = new ArrayList<>();
        separators.add(',');
        separators.add(':');
    }

    public void extractSeparatorFromInput() {
        while (hasSeparator(string)) {
            char separator = string.charAt(2);
            if (isWrongSeparator(separator)) {
                throw new IllegalArgumentException();
            }
            separators.add(separator);
            string = string.substring(5);
        }
    }

    private boolean hasSeparator(String string) {
        return string.indexOf("//") == 0 && string.indexOf("\\n") == 3;
    }

    private boolean isWrongSeparator(char separator) {
        return separator == '/' || separator == '\\' || separator == 'n';
    }
}
