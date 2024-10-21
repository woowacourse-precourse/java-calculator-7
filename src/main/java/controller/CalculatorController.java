package controller;

import model.Calculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    //의존성 추가


    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }


    /**
     * 문자열 계산기를 실행하는 메서드
     **/
    public void calculate() {
        // 문자열 입력 받기
        String input = inputView.input();

        // Calculator를 사용하여 입력 문자열의 합을 계산
        Calculator calculator = Calculator.from(input); // 수정된 부분
        Long sum = calculator.sum();

        // 결과 출력
        outputView.output(sum.intValue());
    }
}
