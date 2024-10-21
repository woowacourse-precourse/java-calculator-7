package calculator;

import calculator.controller.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.getInput();

        StringCalculator calculator = new StringCalculator();
        calculator.run(input);

        OutputView outputView = new OutputView();
        outputView.printResult(calculator.getResult());
    }
}
