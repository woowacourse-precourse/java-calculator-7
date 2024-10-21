package calculator;

import java.util.Arrays;

public class StandardDelimiterCalculator {
    public static int calculateSum(String input) {
        String[] tokens = input.split("[,|:]");

        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())  // 빈 문자열 제외
                .mapToInt(Integer::parseInt)       // 문자열을 정수로 변환
                .sum();
    }
}
