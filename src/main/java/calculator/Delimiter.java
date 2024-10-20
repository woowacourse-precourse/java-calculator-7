package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    public static int add(String input) {
        // 빈 문자열 또는 null 입력 시 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        // 기본 구분자: 쉼표(,)와 콜론(:)
        String delimiter = ",|:";

        // 커스텀 구분자: //와 \n 사이의 int
        Matcher m = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = Pattern.quote(m.group(1)); // 커스텀 구분자를 추출
            input = m.group(2); // 숫자 문자열 추출
        }

        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    public static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            checkValidNumber(number); // 유효성 검사 및 숫자 변환 처리
            total += Integer.parseInt(number); // 변환된 숫자 더하기
        }
        return total;
    }

    // 숫자 유효성 검사 및 음수 검사
    public static void checkValidNumber(String num) {
        int value;

        try {
            value = Integer.parseInt(num); // 숫자로 변환
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력이 불가능한 문자가 포함되어있습니다.");
        }

        // 음수일 경우 예외 발생
        if (value <= 0) {
            throw new IllegalArgumentException("0과 음수는 입력할 수 없습니다.");
        }
    }
}