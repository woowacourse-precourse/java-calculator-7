package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterCalculator {

    public static int calculateSum(String input) {
        // 입력값에서 \\n을 실제 줄바꿈으로 변환
        input = input.replace("\\n", "\n");

        // 정규식으로 한 글자 커스텀 구분자와 숫자 부분을 추출
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);  // 커스텀 구분자 추출
            String numbers = matcher.group(2);  // 숫자 부분 추출

            // 커스텀 구분자로 숫자를 분리하고 합산
            String[] tokens = numbers.split(Pattern.quote(customDelimiter));
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
    }
}

