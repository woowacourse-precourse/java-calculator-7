package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Calculator calculator = new Calculator();
        int result = calculator.run(inputView.readInput());

        outputView.printResult(result);
    }
}
