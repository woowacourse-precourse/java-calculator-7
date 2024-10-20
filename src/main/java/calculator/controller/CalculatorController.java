package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view = new CalculatorView();
    private final CalculatorModel model = new CalculatorModel();

    public void run() {
        try {
            // 사용자 입력
            String input = view.getInput();

            // 입력값 유효성 검증
            model.validateInput(input);

            // 계산 로직 실행
            int result = model.calculateSum(input);

            // 결과 출력
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            // 잘못된 입력 처리
            view.displayError(e.getMessage());
            throw e;
        }
    }
}
