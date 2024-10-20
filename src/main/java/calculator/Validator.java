package calculator;

public class Validator {
    public static void checkInputValid(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException("문자열에 음수 혹은 숫자가 아닌 것은 포함될 수 없습니다.");
            } else {
                if (Integer.parseInt(str) == 0) {
                    throw new IllegalArgumentException("문자열에 양수만 포함될 수 있습니다");
                }
            }
        }
    }

    public static void checkCustomStyle(String str) {
        if (!str.startsWith(Application.CUSTOM_DELIMITER_FRONT)) {
            throw new IllegalArgumentException("커스텀 구분자의 입력 양식이 맞지 않습니다.");
        }
    }

    public static void checkCustomEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 빈 문자열이 될 수 없습니다");
        }
    }

}
