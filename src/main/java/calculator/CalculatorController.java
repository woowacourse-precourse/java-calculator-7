package calculator;

import java.util.NoSuchElementException;

public class CalculatorController {
    private final Calculator calculator;
    private final CalculatorView view; // CalculatorView로 변경

    // 생성자
    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    // 프로그램 실행
    public void run() {
        try {
            String userInput = view.getUserInput();
            int result = calculator.calculateSumFromInput(userInput);
            view.showResult(result); // 출력
        } catch (NoSuchElementException e) {
            view.showResult(0); // 빈 입력에 대해 기본 값 반환
        }
    }
}
