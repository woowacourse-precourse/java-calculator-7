package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    // 문자열을 입력받아 숫자의 합을 계산하는 메서드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 추출
                numbers = matcher.group(2); // 나머지 숫자 추출
            } else {
                throw new IllegalArgumentException("에러: 잘못된 입력 형식입니다. ");
            }
        }

        // 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                if (number <= 0) {
                    throw new IllegalArgumentException("에러: 잘못된 입력 형식입니다. " + number);
                }
                sum += number;
            }
        }

        return sum;
    }
}