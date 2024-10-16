package calculator;

import calculator.controller.StringCalculatorController;
import calculator.service.CalculationService;
import calculator.service.InputService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculatorController stringCalculatorController = new StringCalculatorController(
                new InputService(new InputView()),
                new CalculationService(),
                new ParsingService(),
                new OutputView()
        );

        stringCalculatorController.run();
    }
}
