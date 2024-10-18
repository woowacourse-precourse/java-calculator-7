package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class NumberExtractor {
    public List<Integer> extract(String input, Set<Character> delimiters) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (delimiters.contains(c)) {
                if (currentNumber.length() > 0) {
                    numbers.add(parseNumber(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
            } else {
                currentNumber.append(c);
            }
        }

        if (currentNumber.length() > 0) {
            numbers.add(parseNumber(currentNumber.toString()));
        }

        return numbers;
    }

    private int parseNumber(String numberString) {
        try {
            return Integer.parseInt(numberString.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + numberString);
        }
    }
}