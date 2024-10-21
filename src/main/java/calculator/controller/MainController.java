package calculator.controller;

import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    private Separator separator = new Separator();

    public void run() {
        CalculatorController calculatorController = new CalculatorController(separator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String input = inputView.getInput();
        int result = calculatorController.run(input);
        outputView.printResult(result);
    }

    // 테스트를 위한 메서드, 입력을 직접 받음
    public int runWithInput(String input) {
        CalculatorController calculatorController = new CalculatorController(separator);
        return calculatorController.run(input);
    }
}
