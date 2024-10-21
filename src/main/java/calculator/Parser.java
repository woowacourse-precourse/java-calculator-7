package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static List<Double> parse(String input) {
        List<String> delimiters = new ArrayList<>();
        addDefaultDelimiters(delimiters);

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX))
            input = adjustCustomDelimiter(input, delimiters);

        String[] targets = splitInput(input, delimiters);
        return convert(targets);
    }

    private static void addDefaultDelimiters(List<String> delimiters) {
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);
    }

    private static String adjustCustomDelimiter(String input, List<String> delimiters) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEndIndex == -1)
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");

        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
        delimiters.add(customDelimiter);

        return input.substring(delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length());
    }

    private static String[] splitInput(String input, List<String> delimiters) {
        List<String> quoteDelimiters = new ArrayList<>();
        for (String delimiter: delimiters)
            quoteDelimiters.add(Pattern.quote(delimiter));

        String splitPattern = String.join("|", quoteDelimiters);
        return input.split(splitPattern);
    }

    private static List<Double> convert(String[] targets) {
        List<Double> numbers = new ArrayList<>();

        for (String target: targets) {
            double number = Validator.validateNumber(target);
            numbers.add(number);
        }

        return numbers;
    }
}
