package calculator.regex;

import delimiter.Delimiter;
import delimiter.Delimiters;

public class RegexGenerator {

    private static final String DEFAULT_DELIMITER_AREA_REGEX = "(:(?=\\d+))|(,(?=\\d+))|(\\/\\/([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)\\\\n)";

    public Regex getExcludingDelimiterAreaRegex(final Delimiters delimiters) {
        Regex regex = new Regex(DEFAULT_DELIMITER_AREA_REGEX);

        for (Delimiter delimiter : delimiters.getDelimiters()) {
            regex.add(delimiter.getDelimiter());
        }

        return regex;
    }

}
