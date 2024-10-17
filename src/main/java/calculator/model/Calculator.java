package calculator.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {

    public static int calculate(List<Operand> operands) {
        AtomicInteger sum = new AtomicInteger(0);
        operands.forEach(operand -> {
            sum.addAndGet(operand.number());
        });
        return sum.get();
    }
}
