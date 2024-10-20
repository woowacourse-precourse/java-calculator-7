package calculator.model;

import java.util.regex.Pattern;

public class AddedString {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = parseNumbers(input);
        return sum(numbers);
    }

    private String[] parseNumbers(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex); // "//"와 "\n" 사이의 구분자 추출
                delimiter += "|" + Pattern.quote(customDelimiter); // 기본 구분자와 커스텀 구분자 모두 포함, 커스텀 구분자를 안전하게 처리
                numbers = input.substring(delimiterEndIndex + 1); // 숫자 부분 추출
            }
        }

        // 기본 구분자와 커스텀 구분자를 모두 사용하여 분리
        return numbers.split(delimiter);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
