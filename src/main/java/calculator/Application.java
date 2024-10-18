package calculator;

import calculator.calculator.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String input = getInput();
        int result = calculateResult(input);
        printResult(result);
    }

    private static String getInput() {
        return InputView.inputExpression();
    }

    private static int calculateResult(String input) {
        Calculator calculator = new Calculator(input);
        return calculator.calculate();
    }

    private static void printResult(int result) {
        OutputView.printResult(result);
    }
}
