package calculator.domain.validator;

public class InputValidator {

    private static final String REGEX_NUMERIC = "\\d+";

    /**
     * 입력 문자열이 음수이거나 0인지 확인합니다.
     *
     * @param input 검증할 문자열
     * @return 음수이거나 0이면 true, 그렇지 않으면 false
     */
    public boolean isNonPositiveNumber(String input) {
        input = input.trim().replaceFirst("^0+(?!$)", "");

        return input.startsWith("-") || input.equals("0");
    }

    /**
     * 입력 문자열이 비어있는지 또는 null인지 확인합니다.
     *
     * @param input 검증할 문자열
     * @return 입력이 비어있거나 null이면 true, 그렇지 않으면 false
     */
    public boolean checkInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    /**
     * 입력 문자열이 숫자만으로 구성된 유효한 숫자인지 확인합니다.
     *
     * @param str 검증할 문자열
     * @return 숫자만으로 이루어져 있으면 true, 그렇지 않으면 false
     */
    public boolean isValidNumber(String str) {
        return str.matches(REGEX_NUMERIC);
    }

}
