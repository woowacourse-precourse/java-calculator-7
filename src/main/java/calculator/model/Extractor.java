package calculator.model;

import static calculator.validate.Validator.validateMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//([\\s\\S]*?)\\\\n([\\s\\S]*)";

    public String[] extractNumber(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            String customDelimiter = findGroupByRegex(input).group(1);
            String numberContent = findGroupByRegex(input).group(2);
            return numberContent.split(DEFAULT_DELIMITER + "|" + customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static Matcher findGroupByRegex(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        validateMatcher(matcher);
        return matcher;
    }
}
