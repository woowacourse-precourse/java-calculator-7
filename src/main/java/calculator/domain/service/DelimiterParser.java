package calculator.domain.service;

import calculator.domain.dto.DelimiterParserResult;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.+?)\n";
    private String removedString;

    private void addBasicDelimiters(ArrayList delimiters) {
        delimiters.add(",");
        delimiters.add(":");
    }

    public DelimiterParserResult parsingDelimiters(String inputString) {
        ArrayList delimiters = new ArrayList();

        inputString = inputString.replace("\\n", "\n");
        removedString = inputString;

        Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = customDelimiterPattern.matcher(inputString);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(Pattern.quote(customDelimiter));
            removedString = inputString.substring(matcher.end());
        }

        addBasicDelimiters(delimiters);
        return new DelimiterParserResult(delimiters, removedString);
    }
}
