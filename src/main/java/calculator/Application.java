package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.getInput();

        int result = StringAddCalculator.calculate(input);

        OutputView.printResult(result);



    }
}
