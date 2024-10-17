package calculator;

public class StringCalculation {

    private final InputView inputView;
    private final OutputView outputView;

    StringCalculation(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startCalculate() {
        StringProcessor stringProcessor = new StringProcessor();

        String[] splitedString = stringProcessor.splitWithDelimiter(inputView.inputString());
    }

}
