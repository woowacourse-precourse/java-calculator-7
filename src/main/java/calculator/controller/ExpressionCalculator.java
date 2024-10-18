package calculator.controller;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ExpressionCalculator {

    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 입력받은 문자열을 계산하는 메서드
    public static int calculate(String input) {
        String[] delimiterAndNumbers = parseIntput(input);
        String delimiters = delimiterAndNumbers[0];
        String numbers = delimiterAndNumbers[1];

        // 합산 결과 반환
        return sum(numbers, delimiters);
    }

    // 커스텀 구분자가 있는지 확인하고, 구분자와 숫자 문자열을 추출하는 메서드
    private static String[] parseIntput(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        String numbers = input;

        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, 3);
            delimiters += "|" + Pattern.quote(customDelimiter);
            numbers = input.substring(5);
        }

        return new String[] { delimiters, numbers };
    }

    // 합산하는 메서드
    private static int sum(String numbers, String delimiters) {
        StringTokenizer tokenizer = new StringTokenizer(numbers, delimiters);
        int sum = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int number = Integer.parseInt(token);

            sum += number;
        }

        return sum;
    }
}