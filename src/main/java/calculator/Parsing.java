package calculator;

import java.util.*;

// 구분자를 통한 문자열 파싱
public class Parsing {

    Set<String> checkSeparator = new HashSet<>(Arrays.asList(",", ":"));


    public long calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitString(input);
        return sum(numbers);
    }

    private String[] splitString(String input) {
        List<String> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            if (newLineIndex != -1) {
                String customDelimiter = input.substring(2, newLineIndex);
                checkSeparator.add(customDelimiter);
                input = input.substring(newLineIndex + 2);
            }
        }

        int i = 0;
        while (i < input.length()) {
            boolean isDelimiter = false;
            for (String delimiter : checkSeparator) {
                if (input.startsWith(delimiter, i)) {
                    if (!currentNumber.isEmpty()) {
                        numbers.add(currentNumber.toString());
                        currentNumber = new StringBuilder();
                    }
                    i += delimiter.length();
                    isDelimiter = true;
                    break;
                }
            }
            if (!isDelimiter) {
                currentNumber.append(input.charAt(i));
                i++;
            }
        }

        if (!currentNumber.isEmpty()) {
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
