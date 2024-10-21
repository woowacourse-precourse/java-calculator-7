package calculator.controller;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.view.OutputView;

// 계산기 생성, 덧셈 수행
public class CalculatorController {

    public CalculatorController() {
        Calculator calculator = new Calculator(CalculatorService.getNumbers());
        System.out.println(OutputView.userOutput(calculator.CalcSum()));
    }

}
