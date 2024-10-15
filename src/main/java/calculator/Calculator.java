package calculator;

import java.util.List;

public class Calculator {

    private final InputStringParser parser;
    private final ListCalculator calculator;

    public Calculator(InputStringParser parser, ListCalculator calculator) {
        this.parser = parser;
        this.calculator = calculator;
    }

    public long calculate(String input) throws IllegalStateException {
        try{
            List<Long> list = parser.parse(input);
            ListValidator.validateIsPosList(list);
            return calculator.calculate(list);
        }catch (IllegalArgumentException e){
            throw new IllegalStateException(e);
        }
    }
}
