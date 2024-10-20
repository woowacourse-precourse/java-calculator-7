package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringAdderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;


    public StringAdderController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        // 입력
        String input = inputView.readInputExpression();
        // 계산 수행
        int result = calculator.calculate(input);
        // 결과 출력
        outputView.printResult(result);
    }

}