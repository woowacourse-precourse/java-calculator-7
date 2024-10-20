package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public List<Integer> extractNumbers(String input, String delimiters) {
        String[] elements = input.split(delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String element : elements) {
            int number;
            try {
                number = Integer.parseInt(element);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다: " + element);
            }

            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            numbers.add(number);
        }
        return numbers;
    }
}