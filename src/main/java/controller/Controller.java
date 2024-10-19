package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final Calculator calculator = new Calculator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void processUserInput() {
        // 입력
        String userInput = inputView.readInput();

        // 비즈니스 로직
        int sum = calculator.processInputAndSum(userInput);

        // 출력
        outputView.printResult(sum);
    }
}
