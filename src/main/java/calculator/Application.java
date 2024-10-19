package calculator;

import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start(InputView.input());
    }
}
