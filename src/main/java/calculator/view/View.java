package calculator.view;

import calculator.constants.CalculatorMessages;
import camp.nextstep.edu.missionutils.Console;

public class View {

    public String executeInput() {
        printMessage();
        return input();
    }

    public String input() {
        return Console.readLine();
    }
    public void printMessage() {
        System.out.println(CalculatorMessages.INPUT_MESSAGE);
    }

    public void printResultMessage(Integer result) {
        System.out.println(CalculatorMessages.RESULT_MESSAGE + result);
    }
}
