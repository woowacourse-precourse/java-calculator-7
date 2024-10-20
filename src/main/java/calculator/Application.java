package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        new OutputView(calculator.calculateNumber());
    }
}
