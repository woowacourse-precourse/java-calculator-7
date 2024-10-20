package calculator.model;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final Pattern SPECIAL_CHARACTERS_REGEX = Pattern.compile("[?*+()\\[\\]{}.]");
    private static final String CUSTOM_DELIMITER_PREFIX = "\\n"; // \n를 그대로 사용하기 위함.

    private final ExtractLogic extractLogic = new ExtractLogic();
    private final CalculatorOperation calculatorOperation = new CalculatorOperation();
    private final ValidationUtils validationUtils = new ValidationUtils();

    public int calculate(String input) {
        Scanner scanner = new Scanner(input);
        String delimiter = getDelimiter(scanner);
        List<Integer> numbers = getNumbers(scanner, input, delimiter);
        validationUtils.numbersCheck(numbers);
        return calculatorOperation.calculateSum(numbers);
    }

    private String getDelimiter(Scanner scanner) {
        String delimiter = extractLogic.extractDelimiter(scanner.nextLine());
        return hasSpecialCharacters(delimiter) ? Pattern.quote(delimiter) : delimiter;
    }

    private List<Integer> getNumbers(Scanner scanner, String input, String delimiter) {
        if (scanner.hasNextLine()) {
            return extractLogic.extractNumber(scanner.nextLine(), delimiter);
        }
        if (input.contains(CUSTOM_DELIMITER_PREFIX)) {
            return extractLogic.extractNumber(input.substring(input.indexOf(CUSTOM_DELIMITER_PREFIX) + 2),
                    delimiter);
        } else {
            return extractLogic.extractNumber(input, delimiter);
        }
    }

    private boolean hasSpecialCharacters(String delimiter) {
        return SPECIAL_CHARACTERS_REGEX.matcher(delimiter).find();
    }
}
