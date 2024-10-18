package calculator.util;

import delimiter.Delimiter;
import delimiter.Delimiters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegexGenerator {

    private static final String DEFAULT_DELIMITER_AREA_REGEX = "(:(?=\\d+))|(,(?=\\d+))|(\\/\\/([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)\\\\n)";
    private static final List<Character> metaCharacters = new ArrayList<>(Arrays.asList(
            '?', '*', '+', '(', ')', '[', ']', '{', '}'
    ));

    public String getExcludingDelimiterAreaRegex(final Delimiters delimiters) {
        StringBuilder regex = new StringBuilder(DEFAULT_DELIMITER_AREA_REGEX);

        for (Delimiter delimiter : delimiters.getDelimiters()) {
            regex.append('|').append(escapeMetaCharacter(delimiter.getDelimiter()));
        }

        return regex.toString();
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
}
