package calculator;

import java.util.List;

public class Calculator {

    private final OperandsProvider operandsProvider;
    private final Operands operands;

    public Calculator(OperandsProvider operandsProvider) {
        this.operandsProvider = operandsProvider;
        this.operands = new Operands();
    }

    public void enter() {
        List<Long> numbers = operandsProvider.getOperands();
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
