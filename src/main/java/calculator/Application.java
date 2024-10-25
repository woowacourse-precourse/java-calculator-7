package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.DelimiterParser;
import calculator.model.InputValidator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // Model 인스턴스 생성
        Calculator calculator = new Calculator();
        DelimiterParser delimiterParser = new DelimiterParser();
        InputValidator inputValidator = new InputValidator();

        // Service 인스턴스 생성
        CalculatorService calculatorService = new CalculatorService(calculator, delimiterParser, inputValidator);

        // View 인스턴스 생성
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // Controller 인스턴스 생성 및 실행
        CalculatorController calculatorController = new CalculatorController(calculatorService, inputView, outputView);
        calculatorController.run();
    }

}
