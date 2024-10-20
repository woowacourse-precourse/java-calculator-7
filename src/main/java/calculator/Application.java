package calculator;

import calculator.service.StringCalculatorService;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator inputValidator = new InputValidator();

        StringCalculatorService calculatorService = new StringCalculatorService(inputValidator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String input = inputView.getInput();

        int result = calculatorService.calculate(input);

        outputView.printResult(result);


    }
}
