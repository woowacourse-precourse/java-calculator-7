package calculator;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringToNumberConverter stringToNumberConverter = new StringToNumberConverter();
        SummationCalculator summationCalculator = new SummationCalculator();
        outputView.printResult(summationCalculator.sum(stringToNumberConverter.convert(inputView.read())));
    }
}
