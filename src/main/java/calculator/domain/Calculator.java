package calculator.domain;

import calculator.util.parser.NumberParser;

import java.util.Arrays;

import static calculator.util.validator.InputValidator.validate;

public class Calculator {

    private final String input;

    public Calculator(String input) {
        validate(input);
        this.input = input;
    }

}
