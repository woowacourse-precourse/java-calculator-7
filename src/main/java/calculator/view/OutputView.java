package calculator.view;

import calculator.dto.OutputResponse;

import static calculator.message.OutputMessage.RESPONSE_MESSAGE;

public class OutputView {
    public static void outputMessage(OutputResponse response) {
        System.out.print(RESPONSE_MESSAGE.getMessage() + response.result());
    }
}

