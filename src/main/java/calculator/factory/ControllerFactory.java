package calculator.factory;

import calculator.controller.StringCalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class ControllerFactory {

    // Controller 객체를 생성하는 메소드
    public static StringCalculatorController createController() {
        // ServiceFactory를 사용하여 CalculatorService 객체 생성
        CalculatorService calculatorService = ServiceFactory.createCalculatorService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new StringCalculatorController(inputView, outputView, calculatorService);
    }

}
