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

        String numbers = input;
        Set<String> delimiters = new HashSet<>();

        delimiters.add(DEFAULT_DELIMITER_COLON.getValue());
        delimiters.add(DEFAULT_DELIMITER_COMMA.getValue());

        if (inputValidator.containCustomDelimiter(input)) {
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

        String[] filteredNumberTokens = FilteredEmptyString.filterEmptyString(numberTokens);

        for (String number : filteredNumberTokens) {
            if (inputValidator.isMinus(number)) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            if (!inputValidator.isNumeric(number)) {
                throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
            }
        }

        return new ParsedInput(filteredNumberTokens);
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
