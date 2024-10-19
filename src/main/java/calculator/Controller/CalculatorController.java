package calculator.Controller;

import calculator.Model.CalculatorModel;
import calculator.View.CalculatorView;

public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;
    private final InputController validator;

    public CalculatorController(CalculatorModel model, CalculatorView view, InputController validator) {
        this.model = model;
        this.view = view;
        this.validator = validator;
    }

    public void run() {
        try {
            String input = view.getInput();
            if (input == null || input.isEmpty()) {
                view.showResult(0); // 입력이 없을 때 0 출력
                return;
            }

            // 구분자 처리 및 입력 검증
            String[] inputArr = validator.processInput(input);

            // 숫자 배열로 변환 후 모델에 전달하여 계산 수행
            int[] inputIntArr = model.convertToIntArray(inputArr);
            int sum = model.sum(inputIntArr);
            view.showResult(sum);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage()); // 예외 발생 시 오류 메시지 출력
        }
    }
}
