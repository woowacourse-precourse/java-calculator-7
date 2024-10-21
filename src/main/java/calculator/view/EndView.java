package calculator.view;

import static calculator.enumStatus.UserMessage.END_MESSAGE;

public class EndView {
    public static void printEndView(int result) {
        System.out.println(END_MESSAGE + String.valueOf(result));
    }
}
