package calculator.view;

import calculator.view.enums.Message;

public class OutputView {

    public String getInputPrompt() {
        return Message.INPUT_REQUEST_PROMPT.getMessage();
    }

    public String getFormattedResult(int result) {
        return Message.OUTPUT_RESULT_PROMPT.getMessage() + result;
    }
}
