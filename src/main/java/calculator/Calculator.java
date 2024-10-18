package calculator;

import java.util.List;

public class Calculator {
    private int convertAndSum(List<String> userInput) {
        return userInput.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
