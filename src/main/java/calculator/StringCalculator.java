package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 음수가 입력되면 예외를 던지는 숫자 파싱 메서드
    private int parsePositiveNumber(String number) {
        int parsedNumber = Integer.parseInt(number.trim());
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
        return parsedNumber;
    }
}
