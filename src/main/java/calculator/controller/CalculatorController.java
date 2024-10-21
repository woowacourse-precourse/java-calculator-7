package calculator.controller;

import calculator.exception.InvalidInputException;
import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator; // 모델 객체

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator; // 모델 초기화
    }

    public void run() {
        String input = CalculatorView.getInput(); // 사용자로부터 입력받기
        try {
            int result = calculator.calculate(input); // calculate 호출
            CalculatorView.showResult(result); // 결과 출력
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage()); // 예외 발생 시 오류 메시지 출력
        }
    }
}