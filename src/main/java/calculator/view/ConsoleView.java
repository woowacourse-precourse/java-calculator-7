package calculator.view;

import calculator.constant.MessageConst;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.NoSuchElementException;

public class ConsoleView {

    public String getUserInput() {
        System.out.println(MessageConst.INPUT_PROMPT);
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public void printResult(BigInteger result) {
        System.out.print(MessageConst.RESULT_MSG + result);
    }

    public void printErrorMessage(String errorMsg) {
        System.out.print(MessageConst.INVALID_INPUT_MSG + errorMsg);
    }
}
