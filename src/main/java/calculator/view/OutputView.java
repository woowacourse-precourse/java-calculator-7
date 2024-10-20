package calculator.view;

public class OutputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void showInputPrompt() {
        showPrompt(INPUT_MESSAGE);
    }

    private void showPrompt(String message) {
        System.out.println(message);
    }
}
