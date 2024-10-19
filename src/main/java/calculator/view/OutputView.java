package calculator.view;

import calculator.view.enums.Message;

public class OutputView {

    public void displayInputPrompt() {
        String inputPromptMessage = Message.INPUT_REQUEST_PROMPT.getMessage();
        System.out.println(inputPromptMessage);
    }

    public void displayResult(int calculatedResult) {
        String resultMessage = Message.OUTPUT_RESULT_PROMPT.getMessage() + calculatedResult;
        System.out.println(resultMessage);
    }
}

