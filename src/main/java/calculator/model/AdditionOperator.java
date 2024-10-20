package calculator.model;

import java.util.Arrays;

public class AdditionOperator implements Operator{

    @Override
    public int calculate(int[] numbs) {
        return Arrays.stream(numbs).sum();
    }

}
