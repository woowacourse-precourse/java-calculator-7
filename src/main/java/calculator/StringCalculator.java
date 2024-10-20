package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 숫자 배열을 합하여 반환하는 메서드
    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parsePositiveNumber(number);
            sum += num;
        }
        return sum;
    }

    // 음수가 입력되면 예외를 던지는 숫자 파싱 메서드
    private int parsePositiveNumber(String number) {
        int parsedNumber = Integer.parseInt(number.trim());
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
        return parsedNumber;
    }
}
