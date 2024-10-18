package calculator;

import calculator.view.InputView;
import calculator.domain.Adder;
import calculator.domain.Separator;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(
                new Adder(),
                new Separator(),
                new InputView(),
                new OutputView());
        calculator.run();
    }

}
