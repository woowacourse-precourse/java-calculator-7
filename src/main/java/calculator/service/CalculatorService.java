package calculator.service;

import calculator.model.CalculatorLogic;
import calculator.validation.InputValidator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final Pattern SPECIAL_CHARACTERS_PATTERN = Pattern.compile("[?*+()\\[\\]{}]");
    private static final String CUSTOM_DELIMITER_MARKER = "\\n";
    private static final String ESCAPE_PREFIX = "\\";

    private final CalculatorLogic calculatorLogic = new CalculatorLogic();
    private final InputValidator inputValidator = new InputValidator();

    public int calculate(String input) {
        inputValidator.inputValidate(input);
        Scanner scanner = new Scanner(input);
        String delimiter = getValidatedDelimiter(scanner);
        List<Integer> validateNumbers = extractValidatedNumbers(input, delimiter, scanner);
        inputValidator.numbersValidate(validateNumbers);
        return calculatorLogic.calculate(validateNumbers);
    }

    private String getValidatedDelimiter(Scanner scanner) {
        String delimiter = calculatorLogic.extractDelimiter(scanner.nextLine());
        if (containsSpecialCharacter(delimiter)) {
            delimiter = ESCAPE_PREFIX + delimiter;
        }
        return delimiter;
    }

    private boolean containsSpecialCharacter(String delimiter) {
        Matcher matcher = SPECIAL_CHARACTERS_PATTERN.matcher(delimiter);
        return matcher.find();
    }

    private List<Integer> extractValidatedNumbers(String input, String delimiter, Scanner scanner) {
        if (scanner.hasNextLine()) {
            return calculatorLogic.extractNumbers(scanner.nextLine(), delimiter);
        } else if (input.contains(CUSTOM_DELIMITER_MARKER)) {
            return calculatorLogic.extractNumbers(input.substring(input.indexOf(CUSTOM_DELIMITER_MARKER) + 2), delimiter);
        } else {
            return calculatorLogic.extractNumbers(input, delimiter);
        }
    }
}
