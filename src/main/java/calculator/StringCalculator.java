package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int calculate(String str) {
        if (str == null) { // null 처리
            return 0;
        }

        // 문자 앞뒤 공백 허용(예시: " 1,2")
        String trimmed = str.trim();

        if (trimmed.isEmpty()) { // empty, blank 문자 처리
            return 0;
        }

        List<Integer> numbers = extractNumbers(str, ',', ':');
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static List<Integer> extractNumbers(String str, char... delimiters) {
        String regex = buildRegex(delimiters);
        String[] numberStrings = str.split(regex);

        try {
            List<Integer> numbers = new ArrayList<>();
            for (String numberString : numberStrings) {
                numbers.add(Integer.parseInt(numberString));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자를 파싱하는 데 문제가 발생했습니다.");
        }
    }

    private static String buildRegex(char[] delimiters) {
        StringBuilder regexBuilder = new StringBuilder();
        for (char delimiter : delimiters) {
            if (!regexBuilder.isEmpty()) {
                regexBuilder.append("|"); // 이전에 구분자가 있었다면 or 연산자 추가
            }
            regexBuilder.append("\\").append(delimiter);
        }
        return regexBuilder.toString();
    }
}
