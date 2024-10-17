package calculator;

import calculator.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String text = inputView.print();
    }
}
