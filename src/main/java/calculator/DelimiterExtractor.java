package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String CUSTOM_DELIMITER_EXTRACT_REGEX = "(?<=\\/\\/)([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)(?=\\\\n)";
    private static final Pattern EXTRACT_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_EXTRACT_REGEX);

    public Delimiters extractCustomDelimiter(final String input) {
        Matcher matcher = EXTRACT_DELIMITER_PATTERN.matcher(input);
        Delimiters delimiters = new Delimiters(new ArrayList<>());

        while (matcher.find()) {
            Delimiter delimiter = new Delimiter(matcher.group());
            delimiters.addDelimiter(delimiter);
        }

        return delimiters;
    }

}
