package calculator;

public class StringSumCalculator {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static InputHandler inputHandler;

    StringSumCalculator() {
        inputHandler = new InputHandler();
    }

    public void start() {
        System.out.println(START_MESSAGE);
        inputHandler.inputString();
    }
}
