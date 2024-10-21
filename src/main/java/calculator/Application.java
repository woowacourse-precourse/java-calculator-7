package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CalcController calcController = new CalcController(new InputView(), new OutputView());
        calcController.run();
    }
}
