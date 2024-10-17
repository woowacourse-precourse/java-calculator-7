package parser;

import global.DelimiterSyntaxIndex;

public class Delimiter {

    public String extractDelimiter(String input) {
        if (validateStartsWith(input) && validateEndsWith(input)) {
            return String.valueOf(input.charAt(DelimiterSyntaxIndex.DELIMITER_INDEX.getKey()));
        }
        return "";
    }

    public String removeDelimiterSyntax(String input) {
        return input.substring(DelimiterSyntaxIndex.DELIMITER_AFTER.getKey());
    }

    public boolean validateHasDefaultOrCustomDelimiter(String input, String customDelimiter) {
        return input.matches("[0-9,:" + customDelimiter + "]*");
    }

    private boolean validateStartsWith(String input) {
        return input.startsWith("//");
    }

    private boolean validateEndsWith(String input) {
        return input.charAt(DelimiterSyntaxIndex.FIRST_END.getKey()) == '\\'
                && input.charAt(DelimiterSyntaxIndex.SECOND_END.getKey()) == 'n';
    }
}
