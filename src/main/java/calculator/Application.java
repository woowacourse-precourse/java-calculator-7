package calculator;

import calculator.console.InputConsole;
import calculator.console.OutputConsole;
import calculator.service.CalculatorService;

public class Application {

    private static CalculatorService calculatorService = new CalculatorService();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputConsole.inputConsole();

        String[] numbers = calculatorService.splitInputString(input);

        int result = calculatorService.calculateSum(numbers);

        OutputConsole.outputConsole(result);

    }
}
