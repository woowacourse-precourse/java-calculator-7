package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputview;
    private final InputView inputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputview = outputView;
    }

    public void run() {
        String expression = inputAddition();
        Calculator calculator = new Calculator(expression);
        Integer result = calculateExpression(calculator, expression);
        outputResult(result);
    }

    private String inputAddition() { // 덧셈 문자열을 입력 받는다.
        return inputView.inputAdditionString();
    }

    private Integer calculateExpression(Calculator calculator,
        String expression) { // 입력받은 문자열에 대해 계산을 진행한다.
        return calculator.calculate(expression);
    }

    private void outputResult(Integer result){ // 결과를 출력한다.
        outputview.printResult(result);
    }
}
