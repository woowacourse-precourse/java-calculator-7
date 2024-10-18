package calculator.view;

import calculator.constant.Message;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    static public String input() {
        System.out.println(Message.GUIDE_MESSAGE);
        return Console.readLine();
    }

    static public void output(int result) {
        System.out.printf("%s%d%n", Message.RESULT_MESSAGE, result);
    }
}
