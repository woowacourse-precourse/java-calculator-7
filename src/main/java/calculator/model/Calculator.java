package calculator.model;

import java.util.List;

public class Calculator {

    public long calculate(Numbers numbers) {
        List<Long> numbersList = numbers.getNumbers();
        if (numbersList.isEmpty()) {
            return 0;
        }
        return numbersList.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}