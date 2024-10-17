package calculator;

import java.util.List;

public class Calculator {

    private final Operands operands;

    public Calculator() {
        this.operands = new Operands();
    }

    public void enter(String input) {
        BasicNumberConverter converter = new BasicNumberConverter(input);
        List<Long> numbers = converter.convert();
        operands.add(numbers);
    }

}
