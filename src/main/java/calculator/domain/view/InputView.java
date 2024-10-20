package calculator.domain.view;

import static calculator.domain.message.UserInputMessage.REQUEST_MESSAGE;

import calculator.domain.dto.InputRequest;
import calculator.domain.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 사용자로부터 입력을 받아 InputRequest 객체로 변환합니다.
     */
    public static InputRequest getInputRequest() {
        System.out.println(REQUEST_MESSAGE.getMessage());
        String input = Console.readLine();
        return InputParser.parseDelimiterAndInput(input);
    }

}
