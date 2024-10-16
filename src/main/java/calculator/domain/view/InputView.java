package calculator.domain.view;

public class InputView {
    private static final String INPUT_TEXT = "덧셈할 문자열을 입력해주세요.";
    private final String inputText;

    public InputView(String s) {
        this.inputText = s;
    }

    public String input() {
        System.out.println(INPUT_TEXT);
        return inputText;
    }
}
