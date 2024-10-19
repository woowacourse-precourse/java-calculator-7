package calculator.domain.validation;

import calculator.domain.error.InputException;
import calculator.domain.message.ErrorMessage;

public class CalculatorParserValidator {
    private CalculatorParserValidator() {
    }
    
    /**
     * 주어진 문자열을 정수로 변환하고, 양수인지 검증하는 메서드.
     * <p>
     * 입력된 문자열이 정수로 변환될 수 없는 경우 또는 변환된 값이 0 이하일 경우 예외를 발생시킵니다.
     *
     * @param number 정수로 변환할 문자열
     * @return 변환된 정수 값 (양수)
     * @throws InputException 입력값이 정수 형식이 아니거나, 변환된 값이 0 이하인 경우
     */
    public static int parseToInt(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw InputException.from(ErrorMessage.POSITIVE_INPUT_REQUIRED);
        }

        if (num <= 0) {
            throw InputException.from(ErrorMessage.POSITIVE_INPUT_REQUIRED);
        }

        return num;
    }
}
