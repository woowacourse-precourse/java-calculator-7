package calculator.domain.view;

import static calculator.domain.message.UserOutputMessage.RESPONSE_MESSAGE;

import calculator.domain.dto.OutputResponse;

public class OutputView {

    public static void outputMessage(OutputResponse response) {
        System.out.print(RESPONSE_MESSAGE.getMessage() + response.result());
    }
}
