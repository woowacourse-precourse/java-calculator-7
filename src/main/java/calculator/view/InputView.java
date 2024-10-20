package calculator.view;

import calculator.dto.InputRequest;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;

import static calculator.message.InputMessage.REQUEST_MESSAGE;

public class InputView {

    public static InputRequest getInputRequest() {
        System.out.println(REQUEST_MESSAGE.getMessage());
        return InputParser.parseDelimiterAndInput(Console.readLine());
    }
}
