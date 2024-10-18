package calculator;

import calculator.parser.InputStringParser;
import calculator.validator.ListValidator;

import java.util.List;

public class Calculator {

    private final InputStringParser parser;
    private final ListCalculator listCalculator;

    public Calculator(InputStringParser parser, ListCalculator calculator) {
        this.parser = parser;
        this.listCalculator = calculator;
    }

    public long calculate(String input){
        List<Long> list = parser.parse(input);
        ListValidator.validatePositiveNumberList(list);
        return listCalculator.calculate(list);
    }
}
