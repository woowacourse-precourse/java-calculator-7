package calculator.model;

import java.util.Scanner;

public class CalculatorService {

    private final ExtractLogic extractLogic = new ExtractLogic();

    private String getDelimiter(Scanner scanner) {
        return extractLogic.extractDelimiter(scanner.nextLine());
    }
}
