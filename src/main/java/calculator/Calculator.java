package calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public int sum(String[] numberTokens) {
        List<Integer> numbers = new LinkedList<>();

        for (String numberToken : numberTokens) {
            if (numberToken.isEmpty()) {
                numbers.add(0);
                continue;
            }

            try {
                int number = Integer.parseInt(numberToken);
                if (number < 0) {
                    throw new IllegalArgumentException("음수입니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
            }
        }

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
