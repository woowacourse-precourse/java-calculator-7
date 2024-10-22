package calculator.View;

import calculator.Message.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCalculationInput() {
        System.out.println(ViewMessage.READ_INPUT_MESSAGE);
        String calculationInput = Console.readLine();
        return calculationInput;
    }
}
