package calculator;

import calculator.controller.Calculator;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Separator separator = new Separator();
        Calculator calculator = new Calculator(inputView, outputView, separator);
        calculator.start();
    }
}
