package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Separator {
    private String string;
    private final List<Integer> numbers;
    private final List<Character> separators;

    public Separator(String string) {
        this.string = string;
        numbers = new ArrayList<>();
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

    public boolean isValidFormula() {
        return string.matches(createRegex());
    }

    private String createRegex() {
        StringBuilder regex = new StringBuilder("^([0-9]+([");
        for (Character separator : separators) {
            regex.append(separator);
        }
        regex.append("][0-9]+)*)?$");
        return regex.toString();
    }

    public void separate() {
        while (!string.matches("([0-9]+)?")) {
            int index = getFirstSeparatorIndex();
            numbers.add(Integer.parseInt(string.substring(0, index)));
            string = string.substring(index + 1);
        }
        if (!string.isEmpty()) {
            numbers.add(Integer.parseInt(string));
        }
    }

    private int getFirstSeparatorIndex() {
        List<Integer> index = new ArrayList<>();
        for (Character separator : separators) {
            int idx = string.indexOf(separator);
            if (idx != -1) {
                index.add(idx);
            }
        }
        Collections.sort(index);
        return index.getFirst();
    }
}
