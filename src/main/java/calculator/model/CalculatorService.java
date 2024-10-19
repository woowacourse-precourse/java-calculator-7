package calculator.model;

import java.util.List;
import java.util.Scanner;

public class CalculatorService {

    private static final String CUSTOM_DELIMITER_PREFIX = "\\n"; // \n를 그대로 사용하기 위함.

    private final ExtractLogic extractLogic = new ExtractLogic();

    private String getDelimiter(Scanner scanner) {
        return extractLogic.extractDelimiter(scanner.nextLine());
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
