package calculator;

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
        } catch (IllegalArgumentException e) {

        }
    }
}
