package calculator;

import calculator.number.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    private final static InputView input = new InputView();
    private final static OutputView output = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Number number = new Number(input.readString());
        output.printResult(number.getResult());
    }
}
