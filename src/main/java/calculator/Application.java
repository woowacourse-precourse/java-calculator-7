package calculator;

import calculator.domain.Calculator;
import calculator.domain.Input;
import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Separator separator = new Separator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Calculator calculator = new Calculator(input, separator, inputView, outputView);
        calculator.start();
    }
}
