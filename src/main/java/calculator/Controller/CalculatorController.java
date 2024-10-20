package calculator.Controller;

import calculator.View.CalculatorView;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void run() {
        String input = view.getUserInput();
        try {
            //TODO: 입력 받은 내용 더하기
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }
}
