package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String text = inputView.print();

        OutputView outputView = new OutputView();
        outputView.print(1L);
    }
}
