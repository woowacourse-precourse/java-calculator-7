package calculator.view;

public class ErrorView {
    private static final String STRING_TO_INTEGER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자로 이루어져야 합니다.";

    public static void stringToIntegerError(){
        System.out.println(STRING_TO_INTEGER_ERROR_MESSAGE);
    }
}
