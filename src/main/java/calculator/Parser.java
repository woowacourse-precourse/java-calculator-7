package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static String[] parse(String input) {
        List<String> delimiters = new ArrayList<>();
        addDefaultDelimiters(delimiters);
        addCustomDelimiter(input, delimiters);
        input = adjustCustomDelimiterPart(input);

        return splitInput(input, delimiters);
    }

    private static void addDefaultDelimiters(List<String> delimiters) {
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);
    }

    private static void addCustomDelimiter(String input, List<String> delimiters) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex == -1)
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
            delimiters.add(customDelimiter);
        }
    }

    private static String adjustCustomDelimiterPart(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        return input.substring(delimiterEndIndex + 1);
    }

    private static String[] splitInput(String input, List<String> delimiters) {
        List<String> quoteDelimiters = new ArrayList<>();
        for (String delimiter: delimiters)
            quoteDelimiters.add(Pattern.quote(delimiter));

        String splitPattern = String.join("|", quoteDelimiters);
        return input.split(splitPattern);
    }
}
