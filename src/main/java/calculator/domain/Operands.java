package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operands {
    private List<Operand> operands = new ArrayList<>();

    public Operands(String[] splitInput) {
        for (String elem : splitInput) {
            Operand operand = new Operand(elem);
            this.operands.add(operand);
        }
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
