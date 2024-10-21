package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAdditionModel {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            numbers = input.substring(delimiterEndIndex + 2).split(delimiter);
        } else {
            numbers = input.split("[,:]");
        }

        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }
}