package calculator;

import java.util.List;

public class StringCalculatorApp {
    public void run() {
        OutputView.printStartMessage();
        String userInput = InputView.readInputString();
        List<String> numbers = Splitter.splitByDelimiter(userInput);
        int sum = Calculator.convertAndSum(numbers);
        OutputView.printSumResult(sum);
    }
}
