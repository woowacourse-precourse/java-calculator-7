package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        List<Integer> numbers = inputView.readNumbers();
        int result = calculator.sum(numbers);
        outputView.printResult(result);
    }
}
