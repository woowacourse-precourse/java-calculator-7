package calculator;

public class Validator {
    private static final String STRING_ERROR_MESSAGE1 = "문자열에 음수 혹은 숫자가 아닌 것은 포함될 수 없습니다.";
    private static final String STRING_ERROR_MESSAGE2 = "문자열에 양수만 포함될 수 있습니다";
    private static final String CUSTOM_ERROR_MESSAGE1 = "커스텀 구분자의 입력 양식이 맞지 않습니다.";
    private static final String CUSTOM_ERROR_MESSAGE2 = "커스텀 구분자는 빈 문자열이 될 수 없습니다";

    public void checkInputValid(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException(STRING_ERROR_MESSAGE1);
            } else {
                if (Integer.parseInt(str) == 0) {
                    throw new IllegalArgumentException(STRING_ERROR_MESSAGE2);
                }
            }
        }
    }

    public void checkCustomStyle(String str) {
        if (!str.startsWith(Application.CUSTOM_DELIMITER_FRONT)) {
            throw new IllegalArgumentException(CUSTOM_ERROR_MESSAGE1);
        }
    }

    public void checkCustomEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_ERROR_MESSAGE2);
        }
    }

}
