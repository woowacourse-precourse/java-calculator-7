package calculator.model;

import java.util.List;

public class Calculator {

    public int calculate(Numbers numbers) {
        List<Integer> numbersList = numbers.getNumbers();
        if (numbersList.isEmpty()) {
            return 0;
        }
        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}