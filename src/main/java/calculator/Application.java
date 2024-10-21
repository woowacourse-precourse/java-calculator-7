package calculator;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputNumber();
        outputView.printResult(Calculator.calculate(inputView.getString()));
    }
}
