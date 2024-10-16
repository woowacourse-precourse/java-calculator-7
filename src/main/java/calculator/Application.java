package calculator;

import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        calculator.start();
    }
}
