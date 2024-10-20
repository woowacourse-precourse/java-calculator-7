package operation;

import java.util.List;

public class PlusOperator implements Operator {

    @Override
    public int operate(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
