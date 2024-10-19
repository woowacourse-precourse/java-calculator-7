package calculator.domain.parser;

import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COLON;
import static calculator.domain.CalculatorConstants.DEFAULT_DELIMITER_COMMA;
import calculator.domain.validator.InputValidator;

import calculator.util.FilteredEmptyString;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class InputParser {

    private final InputValidator inputValidator = new InputValidator();
    private final FilteredEmptyString FilteredEmptyString = new FilteredEmptyString();

    public ParsedInput parse(String input) {
        if (inputValidator.checkInputEmpty(input)) {
            return new ParsedInput(new String[]{"0"});
        }

        Set<String> delimiters = initializeDefaultDelimiters();
        String numbers = input;

        if (inputValidator.containCustomDelimiter(input)) {
            numbers = processCustomDelimiter(input, delimiters);
        }

        String[] filteredNumberTokens = tokenizeNumbers(numbers, delimiters);
        validateNumbers(filteredNumberTokens);

        return new ParsedInput(filteredNumberTokens);
    }

    private Set<String> initializeDefaultDelimiters() {
        Set<String> delimiters = new HashSet<>();
        delimiters.add(DEFAULT_DELIMITER_COLON.getValue());
        delimiters.add(DEFAULT_DELIMITER_COMMA.getValue());

        return delimiters;
    }

    private String processCustomDelimiter(String input, Set<String> delimiters) {
        int lastDelimiterIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX.getValue());

        if (lastDelimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.");
        }

        String customDelimiterSection = input.substring(2, lastDelimiterIndex);
        String numbers = input.substring(lastDelimiterIndex + 2);

        delimiters.addAll(extractCustomDelimiters(customDelimiterSection));

        return numbers;
    }

    private String[] tokenizeNumbers(String numbers, Set<String> delimiters) {
        String regex = String.join("|", delimiters);
        String[] numberTokens = numbers.split(regex);

        return FilteredEmptyString.filterEmptyString(numberTokens);
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (inputValidator.isMinus(number)) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            if (!inputValidator.isNumeric(number)) {
                throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    private Set<String> extractCustomDelimiters(String customDelimiterSection) {
        Set<String> delimiters = new HashSet<>();

        for (char ch : customDelimiterSection.toCharArray()) {
            delimiters.add(Pattern.quote(String.valueOf(ch)));
        }

        return delimiters;
     }

    public record ParsedInput(String[] numbers) { }

}
