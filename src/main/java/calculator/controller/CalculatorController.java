package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        String input = InputView.readInput();  // 입력받은 문자열
        Calculator calculator = new Calculator(input);

        try {
            int result = calculator.calculateNumbers();  // 계산기 실행
            OutputView.printResult(result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());  // 에러 메시지 출력
        }
    }
}
