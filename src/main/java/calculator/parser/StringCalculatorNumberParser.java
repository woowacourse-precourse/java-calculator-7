package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorNumberParser implements NumberParser {
    @Override
    public List<Integer> parseNumbers(List<String> numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            if (!numberString.trim().isEmpty()) {
                int number = Integer.parseInt(numberString.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                numbers.add(number);
            }
        }
        return numbers;
    }
}