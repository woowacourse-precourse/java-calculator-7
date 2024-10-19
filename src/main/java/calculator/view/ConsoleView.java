package calculator.view;

import calculator.constant.MessageConst;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class ConsoleView {

    public String getUserInput() {
        System.out.println(MessageConst.INPUT_PROMPT);
        return Console.readLine();
    }

    public void printResult(BigInteger result) {
        System.out.print("\n" + MessageConst.RESULT_MSG + result);
    }

    public void printErrorMessage(String errorMsg) {
        System.out.print("\n" + MessageConst.INVALID_INPUT_MSG + errorMsg);
    }
}
