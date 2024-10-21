package calculator;

import java.util.function.Function;
import java.util.regex.Pattern;

import static calculator.CalculatorConst.*;

public enum ParserPolicy {
    DEFAULT(ParserPolicy::applyDefaultDelimiter),
    CUSTOM(ParserPolicy::applyCustomDelimiter);

    private final Function<String, String> parseFunction;

    ParserPolicy(Function<String, String> parseFunction) {
        this.parseFunction = parseFunction;
    }

    public static ParserPolicy strategy(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_POSITION) ? CUSTOM : DEFAULT;
    }

    public String parseAndStandardize(String input) {
        return parseFunction.apply(input);
    }

    private static String applyDefaultDelimiter(String input) {
        return input.replaceAll(DEFAULT_DELIMITER_PATTERN, COMMON_DELIMITER);
    }

    private static String applyCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END_POSITION);
        String customDelimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, delimiterEndIndex);
        String numbersPart = input.substring(delimiterEndIndex + OFFSET);
        return numbersPart.replaceAll(Pattern.quote(customDelimiter), COMMON_DELIMITER);
    }
}
