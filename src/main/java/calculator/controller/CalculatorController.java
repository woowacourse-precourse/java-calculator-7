package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;

public class CalculatorController {
    static Calculator calculator = new Calculator();

    public static void add() {
        String input = InputView.inputString();
        String[] nums = StringSplitter.splitter(input);
        int[] numbers = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        calculator.setResult(sum);
        OutputView.printResult(calculator);
    }
}
