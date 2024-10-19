package calculator.domain.validation;

import calculator.domain.error.InputException;
import calculator.domain.message.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParserValidator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.{1,5})\\\\n");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");

    /**
     * 입력 문자열의 양쪽 공백을 제거합니다.
     *
     * @param input 공백을 제거할 입력 문자열
     * @return 양쪽 공백이 제거된 문자열
     */
    public static String removeLeadingAndTrailingSpaces(String input) {
        return input.trim();
    }

    /**
     * 입력 문자열이 null이거나 비어 있는지 확인합니다.
     *
     * @param input 확인할 입력 문자열 (null 또는 빈 문자열인지 확인)
     * @throws IllegalArgumentException 입력 문자열이 null이거나 비어 있는 경우
     */
    public static void checkForEmptyInput(String input) {
        if (input == null) {
            throw InputException.from(ErrorMessage.INVALID_INPUT);
        }
    }

    /**
     * 사용자 정의 구분자가 포함된 입력을 검증합니다.
     *
     * @param input 검증할 입력 문자열
     * @return 유효한 경우 Matcher 객체 반환
     * @throws InputException 잘못된 사용자 정의 구분자가 포함된 경우
     */
    public static Matcher validateCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw InputException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER);
        }
        return matcher;
    }

    /**
     * 사용자 정의 구분자가 유효한지 검증합니다.
     *
     * @param customDelimiter 사용자 정의 구분자
     * @throws InputException 구분자에 숫자가 포함된 경우
     */
    public static void validateDelimiter(String customDelimiter) {
        if (INTEGER_PATTERN.matcher(customDelimiter).find()) {
            throw InputException.from(ErrorMessage.INTEGER_IN_DELIMITER);
        }
    }

}
