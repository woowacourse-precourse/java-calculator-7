package calculator;

public class StringCalculation {

    private final InputView inputView;
    private final OutputView outputView;

    StringCalculation(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startCalculate() {
        inputView.inputString();
    }

}
