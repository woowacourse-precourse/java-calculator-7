package calculator.exception;

public class Exception {

    private static final String INPUT_PATTERN_ERROR = "[ERROR] 입력이 잘못되었습니다.";

    public static void exceptionInputPattern() {
        throw new IllegalArgumentException(INPUT_PATTERN_ERROR);
    }
}
