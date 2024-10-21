package calculator.domain.visitor;

import calculator.domain.calculator.CalculatorNumber;

public interface NumberVisitor {
    void visit(CalculatorNumber number);

    long getResult();
}
