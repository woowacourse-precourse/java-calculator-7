package calculator;

import java.util.List;

public class Calculator {

    public int sum(List<String> numberTokens) {
        return numberTokens.stream()
                .map(numberToken -> {
                    if (numberToken.isEmpty()) {
                        return 0;
                    }
                    int number = Integer.parseInt(numberToken);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수입니다.");
                    }
                    return number;
                })
                .mapToInt(Integer::intValue)
                .sum();
    }
}
