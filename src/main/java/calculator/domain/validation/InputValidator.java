package calculator.domain.validation;

import calculator.domain.error.InputException;
import calculator.domain.message.ErrorMessage;

public class InputValidator {

    /**
     * 입력 문자열의 양쪽 공백을 제거합니다.
     *
     * @param input 공백을 제거할 입력 문자열
     * @return 양쪽 공백이 제거된 문자열
     */
    public String removeLeadingAndTrailingSpaces(String input) {
        return input.trim();
    }

    /**
     * 입력 문자열이 null이거나 비어 있는지 확인합니다.
     *
     * @param input 확인할 입력 문자열 (null 또는 빈 문자열인지 확인)
     * @throws IllegalArgumentException 입력 문자열이 null이거나 비어 있는 경우
     */
    public void checkForEmptyInput(String input) {
        if (input == null) {
            throw new InputException(ErrorMessage.MISSING_INPUT);
        }
    }

}
