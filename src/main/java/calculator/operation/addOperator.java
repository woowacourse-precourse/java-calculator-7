package calculator.operation;

import java.util.List;

public class addOperator implements OperatorInterface{

    @Override
    public int operate(List<Integer> numbers){
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
