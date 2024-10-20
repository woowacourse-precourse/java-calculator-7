package calculator;

public class Application {

    public static void main(String[] args) {
        new OutputView().printResult(
                new SummationCalculator().sum(
                        new StringToNumberConverter(new InputView().read()).convert()));
    }
}
