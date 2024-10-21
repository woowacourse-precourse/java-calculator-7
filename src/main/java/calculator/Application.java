package calculator;

import calculator.controller.CalculatorController;
import calculator.service.parse.BigIntegerCalculatorInputParseService;
import calculator.service.CalculatorService;
import calculator.service.parse.PositiveBigIntegerCalculatorInputParseService;
import calculator.service.BigIntegerCalculatorService;
import calculator.view.CalculatorView;

public class Application {

    private static CalculatorController calculatorController;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        BigIntegerCalculatorInputParseService bigIntegerCalculatorInputParseService
                = new PositiveBigIntegerCalculatorInputParseService();
        CalculatorService calculatorService = new BigIntegerCalculatorService(bigIntegerCalculatorInputParseService);
        calculatorController = new CalculatorController(calculatorService);
    }

    private static void run() {
        String input = CalculatorView.sumInput();
        Number result = calculatorController.sum(input);
        CalculatorView.result(result);
    }
}
