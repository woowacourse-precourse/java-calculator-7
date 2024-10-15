package calculator;

import calculator.View.InputView;
import calculator.View.ResultView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputView.getInput();
        try {
            int result = StringAddCalculator.calculate(input);
            ResultView.printResult(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
