package calculator;

import calculator.controller.CalculatorController;
import calculator.service.Adder;
import calculator.service.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController(
                new InputView(),
                new OutputView(),
                new Extractor(),
                new Adder()
        );
        calculatorController.start();
    }
}
