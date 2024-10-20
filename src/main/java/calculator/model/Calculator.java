package calculator.model;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

}
