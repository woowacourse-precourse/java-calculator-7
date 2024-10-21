package calculator.model;

import calculator.controller.CustomDelimiterValidator;
import calculator.controller.InputValueValidator;
import calculator.controller.NumberConverter;
import calculator.controller.StringParser;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final NumberConverter numberConverter;
    private final StringParser stringParser;
    private final InputValueValidator inputValueValidator;
    private final CustomDelimiterValidator customDelimiterValidator;

    private String input;
    private String customDelimiter;
    private List<Long> inputNumbers = new ArrayList<>();
    private boolean usingCustomDelimiter = false;

    public Calculator(NumberConverter numberConverter, StringParser stringParser,
                      CustomDelimiterValidator customDelimiterValidator, InputValueValidator inputValueValidator) {
        this.numberConverter = numberConverter;
        this.stringParser = stringParser;
        this.inputValueValidator = inputValueValidator;
        this.customDelimiterValidator = customDelimiterValidator;
    }

    public void initialize(String input) {
        if (customDelimiterValidator.validate(input)) {
            this.usingCustomDelimiter = true;
            this.customDelimiter = stringParser.customDelimiter(input);
            this.input = input.substring(input.indexOf("\\n") + 2).trim();
        } else {
            this.input = input.substring(input.indexOf("\\n") + 1).trim();
        }
        validateInput();
    }

    public void extractNumber() {
        String[] extract;
        if (usingCustomDelimiter) {
            extract = stringParser.parseNumber(this.input, this.customDelimiter);
        } else {
            extract = stringParser.parseNumber(this.input);
        }

        this.inputNumbers = numberConverter.convert(extract);
    }

    public Long sum() {
        return this.inputNumbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private void validateInput() {
        if (usingCustomDelimiter) {
            inputValueValidator.validate(this.input, customDelimiter);
        } else {
            inputValueValidator.validate(this.input);
        }
    }
}
