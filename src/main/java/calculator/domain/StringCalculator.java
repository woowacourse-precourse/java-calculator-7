package calculator.domain;

import calculator.global.Validator;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int calculate(String input) {
        Validator validator = new Validator();
        if (validator.isEmptyOrBlank(input)) {
            return 0;
        }

        String trimmedInput = input.replaceAll("\\s", "");

        DelimiterStrategy delimiterStrategy = DelimiterStrategyFactory.create(trimmedInput);

        List<String> tokens = delimiterStrategy.split(trimmedInput);

        List<Integer> numbers = validateAndParseNumbers(tokens);
        return sum(numbers);
    }

    private List<Integer> validateAndParseNumbers(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }
        return numbers;
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
