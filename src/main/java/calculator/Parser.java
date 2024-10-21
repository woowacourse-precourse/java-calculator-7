package calculator;

import java.util.regex.Pattern;

public class Parser {

    public int parseNumber(String number) {
        if (number.trim().isEmpty()) {
            return 0;
        }
        int num = Integer.parseInt(number.trim());
        checkNegative(num);
        return num;
    }

    private void checkNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}


