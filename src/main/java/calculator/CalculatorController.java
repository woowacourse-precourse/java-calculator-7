package calculator;

import java.util.NoSuchElementException;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView view;

    // 생성자
    public CalculatorController(Calculator calculator, InputView view) {
        this.calculator = calculator;
        this.view = view;
    }

    // 프로그램 실행
    public void run() {
        try {
            String input = view.getInput();
            int result = calculator.add(input);
            view.printResult(result); // 출력
        } catch (NoSuchElementException e) {
            view.printResult(0); // 빈 입력에 대해 기본 값 반환
        }
    }
}
