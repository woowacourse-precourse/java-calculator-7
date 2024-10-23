package calculator.factory;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.service.CalculatorService;
import calculator.validator.InputValidator;

public class ServiceFactory {

    // CalculatorService 객체를 생성하는 메소드
    public static CalculatorService createCalculatorService() {
        StringParser stringParser = new StringParser();
        StringCalculator stringCalculator = new StringCalculator();
        InputValidator inputValidator = ValidatorFactory.createInputValidator();

        return new CalculatorService(stringParser, stringCalculator, inputValidator);
    }

}
