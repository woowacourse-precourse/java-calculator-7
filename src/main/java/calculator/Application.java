package calculator;

import calculator.domain.AddCalculation;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    private final static InputView input = new InputView();
    private final static OutputView output = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AddCalculation addCalculation = new AddCalculation(input.readString());
        output.printResult(addCalculation.calculation());
    }
}
