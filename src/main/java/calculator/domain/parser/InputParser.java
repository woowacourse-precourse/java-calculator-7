package calculator.domain.parser;

import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COLON;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COMMA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class InputParser {

    public ParsedInput parse(String input) {
        Set<String> delimiters = initializeDefaultDelimiters();
        String stringNumbers = input;

        if (containCustomDelimiter(input)) {
            stringNumbers = processCustomDelimiter(input, delimiters);
        }

        String[] numbersTokens = tokenizeNumbers(stringNumbers, delimiters);

        return new ParsedInput(numbersTokens);
    }

    private Set<String> initializeDefaultDelimiters() {
        Set<String> delimiters = new HashSet<>();
        delimiters.add(DEFAULT_DELIMITER_COLON.getValue());
        delimiters.add(DEFAULT_DELIMITER_COMMA.getValue());

        return delimiters;
    }

    private String processCustomDelimiter(String input, Set<String> delimiters) {
        int lastDelimiterIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX.getValue());

        String customDelimiterSection = input.substring(2, lastDelimiterIndex);
        String numbers = input.substring(lastDelimiterIndex + 2);

        delimiters.addAll(extractCustomDelimiters(customDelimiterSection));

        return numbers;
    }

    private String[] tokenizeNumbers(String numbers, Set<String> delimiters) {
        String regex = String.join("|", delimiters);
        String[] numbersTokens = numbers.split(regex);

        return filterEmptyString(numbersTokens);
    }

    private String[] filterEmptyString(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(Predicate.not(String::isEmpty))
                .toArray(String[]::new);
    }

    private Set<String> extractCustomDelimiters(String customDelimiterSection) {
        Set<String> delimiters = new HashSet<>();

        for (char ch : customDelimiterSection.toCharArray()) {
            delimiters.add(Pattern.quote(String.valueOf(ch)));
        }

        return delimiters;
     }

    public boolean containCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue())
                && input.contains(CUSTOM_DELIMITER_SUFFIX.getValue());
    }

    public record ParsedInput(String[] numbersToken) { }

}
