package calculator.domain.visitor;

import calculator.domain.calculator.CalculatorNumber;

public class SumVisitor implements NumberVisitor {
    private long sum = 0;

    @Override
    public void visit(CalculatorNumber number) {
        sum += number.getValue();
    }

    @Override
    public long getResult() {
        return sum;
    }
}
