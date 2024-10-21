package calculator.executor;

import calculator.provider.OperandsProvider;

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
        Long sum = 0L;
        if (operands.isEmpty()) {
            return sum;
        }
        List<Long> numbers = operands.getOperands();
        for (Long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
