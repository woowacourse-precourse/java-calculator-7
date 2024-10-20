package calculator;

import java.math.BigDecimal;

public class Calculator {

    private final Input input;
    private final Output output;
    private final Separator separator;

    public Calculator(Input input, Output output, Separator separator) {
        this.input = input;
        this.output = output;
        this.separator = separator;
    }

    public void calculate() {
        String userInput = input.input();
        BigDecimal result = separator.separate(userInput);
        output.output(result);
    }
}
