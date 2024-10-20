package calculator.controller;

import calculator.model.calculator.Calculator;
import calculator.model.validator.InputValidator;
import calculator.model.parser.Parser;

public class Controller {
    private final Calculator calculator;
    private final Parser parser;
    private final InputValidator inputValidator;
    public static final String OutputIsZero = "0";

    // 의존성 주입
    public Controller(Calculator calculator, Parser parser, InputValidator inputValidator) {
        this.calculator = calculator;
        this.parser = parser;
        this.inputValidator = inputValidator;
    }

    public String run(String input) {
        //구분자 뽑아서 정수 배열 반환
        return divideCaseByInput(input);
    }

    private String divideCaseByInput(String input) {
        boolean inputIsNull = inputValidator.validate(input);
        if (inputIsNull) {
            return OutputIsZero;
        }
        String [] splitStrings = parser.parsingStringToInteger();
        int [] foundNumber = parser.convertStringsToNumbers(splitStrings);
        return String.valueOf(calculator.calculate(foundNumber));
    }
}
