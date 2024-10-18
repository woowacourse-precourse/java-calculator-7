package calculator;

import calculator.controller.CalculateController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args){
        // TODO: 프로그램 구현
        CalculateController calculateController = new CalculateController(new InputView(), new OutputView());
        calculateController.run();
    }
}
