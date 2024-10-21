package calculator.model;

import calculator.controller.InputSyntaxValidator;
import calculator.controller.InputValueValidator;
import calculator.controller.NumberConverter;
import calculator.controller.StringParser;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final NumberConverter numberConverter;
    private final StringParser stringParser;
    private final InputValueValidator inputValueValidator;
    private final InputSyntaxValidator inputSyntaxValidator;

    private String input;
    private char CustomDelimiter;
    private List<Long> inputNumbers = new ArrayList<>();
    private boolean usingCustomDelimiter;

    public Calculator(NumberConverter numberConverter, StringParser stringParser,
                      InputSyntaxValidator inputSyntaxValidator, InputValueValidator inputValueValidator) {
        this.numberConverter = numberConverter;
        this.stringParser = stringParser;
        this.inputValueValidator = inputValueValidator;
        this.inputSyntaxValidator = inputSyntaxValidator;
    }
}
