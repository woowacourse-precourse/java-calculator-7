package calculator;

import calculator.service.StringCalculatorService;
import calculator.util.StringSplitter;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        StringSplitter stringSplitter = new StringSplitter();

        StringCalculatorService calculatorService = new StringCalculatorService(inputValidator, stringSplitter);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String input = inputView.getInput();

        int result = calculatorService.calculate(input);

        outputView.printResult(result);
    }
}