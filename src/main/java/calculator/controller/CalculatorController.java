package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomCalculator;
import calculator.model.DefaultCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private Calculator calculator;

    public void run() {
        String input = InputView.getLine();
        calculator = setCalculator(input);
        calculator.insertInfo(input);
        calculator.validateExpression();
        calculator.extractNumber();
        OutputView.getOutputMessage(calculator.sum());
    }

    // 입력에 따라 적절한 계산기 주입 (setter injection)
    private Calculator setCalculator(String input) {
        if (input.matches("^//.\\\\n.*")) {
            return new CustomCalculator();  // 커스텀 구분자를 사용하는 계산기
        }
        return new DefaultCalculator();  // 기본 계산기
    }

}
