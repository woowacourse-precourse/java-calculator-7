package calculator.view;

public class OutputView {

    private static final String ADDITION_PROMPT = "덧셈할 문자열을 입력해 주세요.\n";

    private OutputView() {
    }

    public static void printAdditionInputPrompt() {
        System.out.println(ADDITION_PROMPT);
    }
}