package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController() {
        this.model = new CalculatorModel();
        this.view = new CalculatorView();
    }

    public void run() {
        String formula = view.getInput();   // 사용자 입력
        boolean delimiterType = model.getDelimiterType(formula);    // 기본 구분자, 커스텀 구분자 구분하기
        String[] refineFormula = model.validateDelimiter(delimiterType, formula); // 구분자 검증 함수
        int result = model.sum(refineFormula[0], refineFormula[1]);   // 덧셈 구하는 함수
        view.displayResult(result);
    }
}
