package calculator.domain.parser;

import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COLON;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COMMA;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.Arrays;

public class InputParser {

    public ParsedInput parse(String input) {
        if (input == null || input.isEmpty()) {
            return new ParsedInput(new String[]{"0"});
        }

        String numbers = input;
        Set<String> delimiters = new HashSet<>();

        delimiters.add(DEFAULT_DELIMITER_COLON.getValue());
        delimiters.add(DEFAULT_DELIMITER_COMMA.getValue());

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue())) {
            int lastDelimiterIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX.getValue());

            if (lastDelimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.");
            }

            String customDelimiterSection = input.substring(2, lastDelimiterIndex);
            numbers = input.substring(lastDelimiterIndex + 2);

            delimiters.addAll(extractCustomDelimiters(customDelimiterSection));
        }

        String regex = buildRegex(delimiters);
        String[] numberTokens = numbers.split(regex);

        return new ParsedInput(numberTokens);
    }

    private Set<String> extractCustomDelimiters(String customDelimiterSection) {
        Set<String> delimiters = new HashSet<>();

        for (char ch : customDelimiterSection.toCharArray()) {
            delimiters.add(Pattern.quote(String.valueOf(ch)));
        }

        return delimiters;
     }

    private String buildRegex(Set<String> delimiters) {
        return String.join("|", delimiters);
    }

    public record ParsedInput(String[] numbers) { }

}
