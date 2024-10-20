package calculator;

import calculator.ui.InputView;
import calculator.ui.OutputView;
import calculator.util.Util;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Util util = new Util();
        InputView inputView = new InputView(util);
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator(inputView,outputView);
        calculator.run();
    }
}
