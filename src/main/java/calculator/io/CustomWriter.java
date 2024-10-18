package calculator.io;

public class CustomWriter {
    private static final String USER_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInitMessage() {
        System.out.println(USER_INPUT_MESSAGE);
    }
}
