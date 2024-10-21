package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자: 쉼표와 콜론
        String numbers = input;

        // 커스텀 구분자 검사
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 설정
            numbers = matcher.group(2); // 숫자 부분 추출
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token); // 문자열을 정수로 변환
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number; // 정수를 합산
        }

        return sum; // 합산된 결과 반환
    }

    // 문자열을 정수로 변환하는 메소드
    private static int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + str);
        }
    }
}
