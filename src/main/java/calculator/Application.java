package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorInputParseService;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import java.math.BigInteger;

public class Application {

    private static CalculatorController calculatorController;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        CalculatorInputParseService calculatorInputParseService = new CalculatorInputParseService();
        CalculatorService calculatorService = new CalculatorService(calculatorInputParseService);
        calculatorController = new CalculatorController(calculatorService);
    }

    private static void run() {
        String input = CalculatorView.sumInput();
        BigInteger result = calculatorController.sum(input);
        CalculatorView.result(result);
    }
}
