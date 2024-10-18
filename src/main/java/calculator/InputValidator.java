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
    public boolean validateNegative(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                return true;
            }
        }
        return false;
    }

    // 숫자가 아닌 값 검증
    public void validateNonNumeric(String input) {
        //
    }
}
