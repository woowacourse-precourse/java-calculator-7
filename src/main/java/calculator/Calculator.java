package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String input) {

        // 입력이 비었을 때 처리
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));  // 커스텀 구분자 추출
                numbers = matcher.group(2);  // 숫자 추출
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }

        // 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiter);

        try {
            // 숫자 변환 및 합산 수행
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }
}
