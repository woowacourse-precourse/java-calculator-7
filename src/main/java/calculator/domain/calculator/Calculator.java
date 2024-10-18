package calculator.domain.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int sumAll(List<Integer> parsedValues) {
        return parsedValues.stream().mapToInt(Integer::intValue).sum();
    }
}
