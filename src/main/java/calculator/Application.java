package calculator;

import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String input = inputView.getString();

        System.out.println("입력된 문자열 : " + input);
    }
}
