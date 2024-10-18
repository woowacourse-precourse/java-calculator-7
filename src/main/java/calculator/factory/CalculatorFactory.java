package calculator.factory;

import calculator.controller.StringCalculatorController;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorFactory {

    // Controller 및 필요한 모든 객체들을 생성하는 메소드
    public static StringCalculatorController createController() {
        CalculatorService calculatorService = createCalculatorService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new StringCalculatorController(inputView, outputView, calculatorService);
    }

    // CalculatorService 및 관련 객체들을 생성하는 메소드
    private static CalculatorService createCalculatorService() {
        StringParser stringParser = new StringParser();
        StringCalculator stringCalculator = new StringCalculator();
        var inputValidator = ValidatorFactory.createInputValidator();

        return new CalculatorService(stringParser, stringCalculator, inputValidator);
    }
}
