package calculator.domain;

import static calculator.global.exception.ErrorMessage.EMPTY_NUMBER_INPUT;
import static calculator.global.exception.ErrorMessage.INVALID_DELIMITER_INPUT;
import static calculator.global.exception.ErrorMessage.INVALID_STRING_END;
import static calculator.global.exception.ErrorMessage.INVALID_STRING_START;

import calculator.global.exception.CalculatorException;
import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    /*구분자는 에러 없이 들어온다고 가정
     * input 즉 /n 이후의 문자열에 대한 예외 처리 진행
     * 이후 문자열을 정해진 구분자로 나눠주는 과정 진행*/
    /*예외 처리
     * 숫자로 시작하지 않는 경우
     * 숫자로 끝나지 않는 경우
     * 정해진 구분자가 아닌 문자가 들어간 경우*/

    public String[] split(String input, String delimiter) {
        validateInput(input, delimiter);
        return input.split(delimiter);
    }

    //    빈 값, 숫자로 시작, 숫자로 끝나는 지 검증
    private void validateInput(String input, String delimiter) {
        if (input == null || input.isEmpty()) {
            throw CalculatorException.of(EMPTY_NUMBER_INPUT);
        }

        List<String> parts = splitIntoParts(input);
        if (!isValidStart(parts)) {
            throw CalculatorException.of(INVALID_STRING_START);
        }

        if (!isValidEnd(parts)) {
            throw CalculatorException.of(INVALID_STRING_END);
        }

        if (!containsOnlyValidCharacters(parts, delimiter)) {
            throw CalculatorException.of(INVALID_DELIMITER_INPUT);
        }
    }

    //    입력을 모든 문자로 쪼개는 메서드
    private List<String> splitIntoParts(String input) {
        List<String> parts = new ArrayList<>();
        for (char c : input.toCharArray()) {
            parts.add(String.valueOf(c));
        }
        return parts;
    }

    //    숫자로 시작하는지 체크
    private boolean isValidStart(List<String> parts) {
        return Character.isDigit(parts.getFirst().charAt(0));
    }

    //    숫자로 끝나는지 체크
    private boolean isValidEnd(List<String> parts) {
        return Character.isDigit(parts.getLast().charAt(0));
    }

    //    유효한 구분자만 포함되는지 체크
    private boolean containsOnlyValidCharacters(List<String> parts, String delimiter) {
        for (String part : parts) {
            char ch = part.charAt(0);
            if (!Character.isDigit(ch) && !delimiter.contains(part)) {
                return false;
            }
        }
        return true;
    }
}
