package calculator.view;

import calculator.constant.Message;
import camp.nextstep.edu.missionutils.Console;

public class CalculationView {
    public static String input() {
        System.out.println(Message.INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void output(long sum) {
        System.out.printf(Message.OUTPUT_MESSAGE, sum);
    }
}
