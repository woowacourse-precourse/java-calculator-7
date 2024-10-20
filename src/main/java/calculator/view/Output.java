package calculator.view;

import static calculator.constant.OutputMessages.FIRST_MESSAGE;
import static calculator.constant.OutputMessages.RESULT_MESSAGE;

public class Output {

    public static void firstMessage() {
        System.out.println(FIRST_MESSAGE);
    }

    public static void resultMessage() {
        System.out.print(RESULT_MESSAGE);
    }

    public static void result(int result) {
        System.out.println(result);
    }
}
