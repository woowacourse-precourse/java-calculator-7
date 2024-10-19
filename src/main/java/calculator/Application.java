package calculator;

import calculator.view.InputView;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        System.out.println(InputView.inputNumbers());
    }
}
