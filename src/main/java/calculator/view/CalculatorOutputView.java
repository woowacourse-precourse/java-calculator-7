package calculator.view;

import static calculator.view.Output.INPUT_STRING;

public class CalculatorOutputView implements OutputView {

    @Override
    public void inputString() {
        System.out.println(INPUT_STRING.getMessage());
    }

    @Override
    public void outputResult(int result) {

    }
}
