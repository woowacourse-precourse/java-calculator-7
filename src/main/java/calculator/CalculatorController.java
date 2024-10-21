package calculator;

public class CalculatorController {

    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    // 덧셈 연산을 처리하고 결과를 출력하는 메서드
    public void run() {
            // 입력 받기
            String input = inputView.getInput();

            // 계산 수행
            int result = calculator.add(input);

            // 결과 출력
            outputView.printResult(result);

    }
}