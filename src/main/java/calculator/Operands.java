package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private List<Long> operands;

    public Operands() {
        this.operands = new ArrayList<>();
    }

    public void add(List<Long> numbers) {
        operands.addAll(numbers);
    }

    public boolean isEmpty() {
        return operands.isEmpty();
    }

    public List<Long> getOperands() {
        return operands;
    }
}
