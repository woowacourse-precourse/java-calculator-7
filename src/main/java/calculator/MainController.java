package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class MainController {
    public static void run() {
        String inputString = InputView.readString();
        int sumResult = Calculator.calculateSum(inputString);
        OutputView.printResult(sumResult);
    }
}
