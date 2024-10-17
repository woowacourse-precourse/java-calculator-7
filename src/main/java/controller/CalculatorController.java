package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void runController() {
        //입력받기
        String input = view.getInput();

        //커스텀 구분자 설정 및 문자열 가공
        String new_input = model.checkCustomDelimiter(input);

        //빈 문자열인지 체크
        if (new_input.isEmpty()) {
            view.displayResult(0);
        } else {
            //숫자와 구분자 필터링
            model.filterInput(new_input);
            //숫자들의 합 계산
            int result = model.addNumber();
            //결과 출력하기
            view.displayResult(result);
        }
    }
}
