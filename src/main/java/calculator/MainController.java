package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    public static void run() {
        String inputString = InputView.readString();
        int sumResult = PlusCalculator.calculateSum(inputString);
        OutputView.printResult(sumResult);
    }
}
