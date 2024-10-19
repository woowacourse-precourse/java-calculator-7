package calculator.domain.machine;

import java.util.List;

public class Engine {

    private final LineSplitter lineSplitter;

    public Engine(LineSplitter lineSplitter) {
        this.lineSplitter = lineSplitter;
    }

    public Long operate(String target) {
        List<Long> operands = lineSplitter.getOperands(target);

        return getResultOfAddition(operands);
    }

    private Long getResultOfAddition(List<Long> operands) {
        return operands.stream().mapToLong(operand -> operand).sum();
    }
}
