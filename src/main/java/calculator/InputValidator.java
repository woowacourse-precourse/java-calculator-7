package calculator;

import java.util.List;

public class InputValidator {

    // 0 또는 자연수만 허용
    private static final String VALID_OPERANDS = "^(0|[1-9][0-9]*)$";

    // 피연산자의 값이 유효한지 검증
    public static void validate(List<String> operands) {
        operands.forEach(InputValidator::checkOperand);
    }

    // 피연산자의 값이 범위 내에 존재하는지 검증
    private static void checkOperand(String operand) {
        if (!operand.matches(VALID_OPERANDS)) {
            throw new IllegalArgumentException("0 또는 자연수만 입력해주세요. 기본 구분자 [, or :]");
        };
    }

    // null, 빈 값 확인
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
