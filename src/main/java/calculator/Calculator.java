package calculator;

import java.util.regex.Pattern;

public class Calculator {

    static double add(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        } else if (input.isEmpty()) {
            return 0;
        } else {
            String[] tokens = tokenize(input);
            return sum(tokens);
        }
    }

    static String[] tokenize(String input) {
        String delimiter = ",|:"; // 기본 구분자

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex)); // 커스텀 구분자 추출
            input = input.substring(delimiterEndIndex + 2); // 숫자 부분만 추출
        }

        return input.split(delimiter); // 구분자로 문자열 분리
    }

    static double sum(String[] tokens) {}
}