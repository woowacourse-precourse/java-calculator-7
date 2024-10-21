package calculator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();

        String input = inputView.getInput();

        int result = calculator.addNumbers(input);

        outputView.printResult(result);

    }
}
