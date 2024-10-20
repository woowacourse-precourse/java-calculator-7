package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Storage;
import calculator.model.Calculator;
import calculator.model.Extractor;
import calculator.model.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController controller = new CalculatorController(new InputView(), new OutputView(),
                new Validator(), new Extractor(),
                new Calculator(), new Storage());
        controller.start();
    }
}
