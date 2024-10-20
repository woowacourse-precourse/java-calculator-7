package calculator;

import calculator.controller.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringCalculator calculator = new StringCalculator();

        String input = inputView.getInput();
        int sum = calculator.calculateInput(input);
        outputView.printResult(sum);
    }
}
