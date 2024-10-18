package calculator;

import java.util.List;

public class InputValidator {
    // 입력값이 빈 문자열인지 확인
    public  int validateEmptyString(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return -1;
    }

    // 음수값 검증
    public void validateNegative(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수 값은 허용되지 않습니다.:" + number);
            }
        }
    }

    // 숫자가 아닌 값 검증
    public void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값이 포함되어 있습니다.");
        }
    }
}
