package calculator;

import calculator.controller.StringCalculatorController;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.service.CalculatorService;
import calculator.validator.ValidatorFactory;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            StringCalculatorController calculatorController = createController();
            calculatorController.run();  // 프로그램 실행
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력 후 프로그램 종료
            System.out.println(e.getMessage());
            throw e;
        }
    }

    // Controller 및 필요한 객체들을 생성하는 메소드
    private static StringCalculatorController createController() {
        StringParser stringParser = new StringParser();
        StringCalculator stringCalculator = new StringCalculator();
        var inputValidator = ValidatorFactory.createInputValidator();

        CalculatorService calculatorService = new CalculatorService(stringParser, stringCalculator, inputValidator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new StringCalculatorController(inputView, outputView, calculatorService);
    }

}