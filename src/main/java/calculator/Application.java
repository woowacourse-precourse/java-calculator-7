package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // CalculatorController에 inputview와 outputview 주입 해줍니다.
        CalculatorController calculatorController = new CalculatorController(
                new InputView(),
                new OutputView()
        );
        // CalculatorController을 실행합니다.
        calculatorController.run();
    }
}
