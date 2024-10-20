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

        return input.split(delimiter); // 구분자로 문자열 분리
    }

    static double sum(String[] tokens) {}
}