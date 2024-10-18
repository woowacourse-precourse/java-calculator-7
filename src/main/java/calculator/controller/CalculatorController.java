package calculator.controller;

import calculator.model.Expression;
import calculator.model.Terms;
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
        String rawExpression = inputAddition();
        Expression expression = new Expression(rawExpression);
        Integer result = calculateExpression(expression.getTerms());
        outputResult(result);
    }

    private String inputAddition() { // 덧셈 문자열을 입력 받는다.
        return inputView.inputAdditionString();
    }

    private Integer calculateExpression(Terms terms) { // 입력받은 문자열에 대해 계산을 진행한다.
        return terms.addition();
    }

    private void outputResult(Integer result) { // 결과를 출력한다.
        outputview.printResult(result);
    }
}
