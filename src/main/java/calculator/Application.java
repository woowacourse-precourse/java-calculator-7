package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operations;
import calculator.view.InputHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new InputHandler());
        OutputView outputView = new OutputView();
        Operations operations = new Operations();
        Calculator calculator = new Calculator(inputView, outputView, operations);

        calculator.run();
    }
}