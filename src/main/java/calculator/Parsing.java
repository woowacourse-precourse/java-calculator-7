package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 구분자를 통한 문자열 파싱
public class Parsing {

    Set<Character> checkSeparator = new HashSet<>();

    public long calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        checkSeparator.add(',');
        checkSeparator.add(':');

        String[] numbers = splitString(input);
        return sum(numbers);
    }

    private String[] splitString(String input) {
        List<String> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (checkSeparator.contains(c)) {
                if (currentNumber.length() > 0) {
                    numbers.add(currentNumber.toString());
                    currentNumber = new StringBuilder();
                }
            } else {
                currentNumber.append(c);
            }
        }

        if (currentNumber.length() > 0) {
            numbers.add(currentNumber.toString());
        }

        return numbers.toArray(new String[0]);
    }

    private long sum(String[] numbers) {
        long total = 0;
        for (String number : numbers) {
            total += parseNumber(number);
        }
        return total;
    }

    private long parseNumber(String number) {
        try {
            long value = Long.parseLong(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }

}
