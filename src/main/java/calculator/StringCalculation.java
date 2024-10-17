package calculator;

public class StringCalculation {

    private final InputView inputView;
    private final ResultView resultView;

    StringCalculation(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startCalculate() {
        StringProcessor stringProcessor = new StringProcessor();

        String[] splitedString = stringProcessor.splitWithDelimiter(inputView.inputString());
        resultView.printResult(stringProcessor.calculate(splitedString));

    }

}
