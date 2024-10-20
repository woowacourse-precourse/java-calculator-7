package calculator;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calculator calculator = new Calculator();
        // 사용자 입력
        String inp = inputView.askInput();

        // 덧셈 계산
        Integer sum = calculator.add(inp);

        // 결과 출력
        outputView.printSumResult(sum);
    }
}
