package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String input) {
        // 입력값이 null이거나 빈 문자열이면 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자: 쉼표(,) 또는 콜론(:)

        // 커스텀 구분자가 있는지 확인하고 처리
        if (input.startsWith("//")) {
            // "//"로 시작하는 경우, 커스텀 구분자와 실제 숫자 부분을 추출하기 위한 정규식 패턴 설정
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);  // \\n 처리
            if (matcher.find()) {
                // 커스텀 구분자를 추출하여 구분자로 사용
                delimiter = Pattern.quote(matcher.group(1));
                // 커스텀 구분자 이후의 실제 숫자 문자열을 추출
                input = matcher.group(2);
            }
        }

        // 추출한 구분자를 기준으로 문자열을 숫자 배열로 분리
        String[] numbers = input.split(delimiter);
        // 분리한 숫자들의 합을 계산하여 반환
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        // 배열 내의 각 숫자에 대해 처리
        for (String number : numbers) {
            int num = parseNumber(number);
            // 음수가 있는 경우 IllegalArgumentException 발생
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            // 숫자를 합산
            sum += num;
        }
        return sum;
    }

    private int parseNumber(String number) {
        // 빈 문자열일 경우 0을 반환
        if (number.isEmpty()) {
            return 0;
        }
        // 문자열을 정수로 변환하여 반환
        return Integer.parseInt(number);
    }
}
