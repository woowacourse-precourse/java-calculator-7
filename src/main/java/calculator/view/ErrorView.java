package calculator.view;

public class ErrorView {
    private static final String STRING_TO_INTEGER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자로 이루어져야 합니다.";
    private static final String DELIMITER_LENGTH_ERROR_MESSAGE = "[ERROR] 커스텀 구분자는 1글자로 이루어져야 합니다..";

    public static void stringToIntegerError(){
        System.out.println(STRING_TO_INTEGER_ERROR_MESSAGE);
    }

    public static void delimiterLengthError() {
        System.out.println(DELIMITER_LENGTH_ERROR_MESSAGE);
    }
}
