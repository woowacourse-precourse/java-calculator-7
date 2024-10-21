package calculator.stringCalculator.calculator;

import java.util.List;

public class Calculator {

    public long sum(List<Long> numberList) {
        return numberList.stream().mapToLong(Long::longValue).sum();
    }
}
