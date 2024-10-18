package calculator.view;

import calculator.dto.request.CalculatorRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static CalculatorRequest enterRequest() {
        System.out.println(ViewMessages.NUMBERS_REQUEST_MESSAGE);
        String input = Console.readLine();
        return ViewCalculatorParser.parseDelimitersAndInput(input);
    }
}
