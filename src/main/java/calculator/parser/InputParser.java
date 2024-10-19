package calculator.parser;

import calculator.validator.InputValidator;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {

    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";

    private final InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public String[] parseInput(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            inputValidator.validateCustomDelimiterFormat(input);
            inputValidator.validateSingleCustomDelimiter(input);

            String[] parts = input.split(Pattern.quote(DELIMITER_SUFFIX), 2);
            return new String[]{parts[0], parts[1]};
        }

        inputValidator.validateCustomDelimiterSpecificIndex(input);

        return new String[]{null, input};
    }

    public Character parseCustomDelimiterPart(String customDelimiterPart) {
        String regex = Pattern.quote(DELIMITER_PREFIX) + "(.*)";

        Matcher matcher = Pattern.compile(regex).matcher(customDelimiterPart);
        inputValidator.validateCustomDelimiterExtraction(matcher.find());

        String findCustomDelimiterString = matcher.group(1);
        inputValidator.validateCustomDelimiterIsCharacter(findCustomDelimiterString);

        Character findCustomDelimiter = findCustomDelimiterString.charAt(0);
        inputValidator.validateDelimiterIsNotDigit(findCustomDelimiter);

        return findCustomDelimiter;
    }

    public List<BigDecimal> parseCalculationPartByDelimiters(String calculationPart, List<Character> delimiters) {
        inputValidator.validateInvalidDelimiters(calculationPart, delimiters);
        String delimiterRegex = buildDelimiterRegex(delimiters);

        return getNumbersWithDelimiterRegex(calculationPart, delimiterRegex);
    }

    private List<BigDecimal> getNumbersWithDelimiterRegex(String calculationPart, String delimiterRegex) {
        return List.of(calculationPart.split(delimiterRegex)).stream()
                .map(value -> {
                    if (value.isEmpty()) {
                        return BigDecimal.ZERO;
                    }
                    inputValidator.validateNumber(value);
                    return new BigDecimal(value);
                })
                .collect(Collectors.toList());
    }

    private String buildDelimiterRegex(List<Character> delimiters) {
        return delimiters.stream()
                .map(delimiter -> Pattern.quote(delimiter.toString()))
                .collect(Collectors.joining("|"));
    }
}
