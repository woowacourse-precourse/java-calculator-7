package calculator.view;

import calculator.view.constant.ViewMessage;

public class CalculatorView {

    public static void inputView() {
        System.out.println(ViewMessage.START_MESSAGE.getMessage());
    }

    public static void outputView(int result) {
        System.out.println(ViewMessage.END_MESSAGE.getMessageWithResult(result));
    }

}