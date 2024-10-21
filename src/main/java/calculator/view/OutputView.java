package calculator.view;

import java.math.BigDecimal;

public class OutputView {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PROMPT_MESSAGE = "결과 : ";

    public void showInputPrompt() {
        showPrompt(INPUT_PROMPT_MESSAGE);
    }

    public void showResult(BigDecimal result) {
        showPrompt(RESULT_PROMPT_MESSAGE + result.toString());
    }

    private void showPrompt(String message) {
        System.out.println(message);
    }
}
