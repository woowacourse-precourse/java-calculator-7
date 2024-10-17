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
            String[] parts = input.split("\n", 2);
            String delimiter = Pattern.quote(parts[0].substring(2));
            numbers = parts[1].split(delimiter);
        } else {
            numbers = input.split("[,:]");
        }

        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }
        return parsedNumber;
    }
}
