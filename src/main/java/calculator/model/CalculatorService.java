package calculator.model;

import java.util.List;
import java.util.Scanner;

public class CalculatorService {

    private static final String CUSTOM_DELIMITER_PREFIX = "\\n"; // \n를 그대로 사용하기 위함.

    private final ExtractLogic extractLogic = new ExtractLogic();
    private final CalculatorOperation calculatorOperation = new CalculatorOperation();
    private final ValidationUtils validationUtils = new ValidationUtils();

    public int calculate(String input) {
        String delimiter = getDelimiter(input);
        List<Integer> numbers = extractLogic.extractNumber(input, delimiter);
        validationUtils.numbersCheck(numbers);
        return calculatorOperation.calculateSum(numbers);
    }

    private String getDelimiter(String input) {
        return extractLogic.extractDelimiter(input);
    }

    private List<Integer> getNumbers(String input, String delimiter, Scanner scanner) {
        String numbersInput;
        if (scanner.hasNextLine()) {
            numbersInput = scanner.nextLine();
        } else if (input.contains(CUSTOM_DELIMITER_PREFIX)) {
            numbersInput = input.substring(input.indexOf(CUSTOM_DELIMITER_PREFIX) + 2);
        } else {
            numbersInput = input;
        }
        return extractLogic.extractNumber(numbersInput, delimiter);
    }
}
