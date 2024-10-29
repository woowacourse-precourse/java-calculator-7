package calculator.util;

import calculator.enums.ErrorMessages;
import calculator.exception.CalculatorException;
import java.util.List;
import java.util.regex.Pattern;

public class StringValidator {

    // 하나 이상의 숫자 형식 정규 표현식
    private static final String VALID_NUMBER_REGEX = "\\d+";

    // 입력 포맷 및 구분자 검증
    public void validate(String input) {
        validateDelimiters(input);
        validateFormat(input);
    }

    // 구분자 검증
    private void validateDelimiters(String input) {
        // 커스텀 구분자 정의 조건에 해당할 경우
        if (input.startsWith("//")) {

            // 커스텀 구분자 정의 종료 부분
            int delimiterEnd = input.indexOf("\\n");

            // 커스텀 구분자 정의 종료 부분이 없다면 예외 발생
            if (delimiterEnd == -1) {
                throw new CalculatorException(ErrorMessages.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
            }

            // 정의 부분을 제외한 커스텀 구분자
            String customDelimiter = input.substring(2, delimiterEnd);

            // 커스텀 구분자가 숫자 형식이라면 예외 발생
            if (isDigit(customDelimiter)) {
                throw new CalculatorException(ErrorMessages.NUMBER_DELIMITER.getMessage());
            }
        }
    }

    // 입력 포맷 검증
    private void validateFormat(String input) {

        // 입력이 비어있거나 공백일 경우 예외 발생
        if (input.isEmpty() || input.isBlank()) {
            throw new CalculatorException(ErrorMessages.EMPTY_INPUT.getMessage());
        }

        // 입력의 첫 번째 문자
        char firstCharacter = input.charAt(0);
        // 입력의 마지막 문자
        char lastCharacter = input.charAt(input.length() - 1);

        // 마지막 문자가 숫자 형식이 아니라면 예외 발생
        if (!isDigit(String.valueOf(lastCharacter))) {
            throw new CalculatorException(ErrorMessages.INVALID_DELIMITER_FORMAT_END.getMessage());
        }

        // 커스텀 구분자를 사용할 경우
        // 입력의 첫 번째 문자를 커스텀 구분자 정의 이후 첫번째 문자로 재정의
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            firstCharacter = input.charAt(delimiterEnd + 2);
        }

        // 첫 번째 문자가 숫자 형식이 아니라면 예외 발생
        if (!isDigit(String.valueOf(firstCharacter))) {
            throw new CalculatorException(ErrorMessages.INVALID_DELIMITER_FORMAT_START.getMessage());
        }
    }

    // 구분자로 구분한 숫자 문자열 검증
    public void validateNumbers(List<String> numbers) {
        for (String number : numbers) {

            // 숫자가 비어있거나 공백이면 예외 발생
            if (number.isEmpty() || number.isBlank()) {
                throw new CalculatorException(ErrorMessages.EMPTY_NUMBER_INPUT.getMessage());
            }

            // 숫자 입력이 아닐 경우 예외 발생
            if (!isDigit(number)) {
                throw new CalculatorException(ErrorMessages.INVALID_NUMBER_INPUT.getMessage() + number);
            }

        }
    }

    // 숫자 형식에 해당하는지 검증
    private boolean isDigit(String input) {
        return Pattern.matches(VALID_NUMBER_REGEX, input);
    }
}
