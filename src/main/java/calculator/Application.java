package calculator;

import calculator.model.Calculator;
import calculator.model.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.displayInputMessage();
        String input = inputView.readInput();

        Calculator calculator = new Calculator();
        Number sum = calculator.sumNumbersFromString(input);

        outputView.displayResultMessage(String.valueOf(sum));
    }
}
