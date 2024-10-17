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

    public Long addAll() {
        if (operands.isEmpty()) {
            return 0L;
        }
        List<Long> numbers = operands.getOperands();
        Long sum = 0L;
        for (Long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
