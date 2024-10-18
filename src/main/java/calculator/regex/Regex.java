package calculator.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Regex {

    private static final List<Character> metaCharacters = new ArrayList<>(Arrays.asList(
            '?', '*', '+', '(', ')', '[', ']', '{', '}', '.', '^', '$', '|'
    ));

    private final StringBuilder regex;

    public Regex(final String regex) {
        this.regex = new StringBuilder(regex);
    }

    public void add(final String value) {
        regex.append('|').append(escapeMetaCharacter(value));
    }

    private StringBuilder escapeMetaCharacter(String value) {
        StringBuilder regex = new StringBuilder();

        for (char c : value.toCharArray()) {
            if (metaCharacters.contains(c)) {
                regex.append("\\").append(c);
                continue;
            }
            regex.append(c);
        }

        return regex;
    }

    public String getRegex() {
        return new String(regex);
    }

}
