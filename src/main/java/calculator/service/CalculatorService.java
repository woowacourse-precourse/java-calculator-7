package calculator.service;

import calculator.util.parser.InputParser;

public class CalculatorService {
    private CalculatorService() {

    }

    public static void printResultOfSum(final String userInput) {
        Long sum = InputParser.extractNumbers(userInput).stream()
                .reduce(0L, Long::sum);
        System.out.println("결과 : " + sum);
    }

}
