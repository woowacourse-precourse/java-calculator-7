package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        String input = InputView.getInput();
        InputParser inputParser = new InputParser(input);
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputParser);

        int result = stringAddCalculator.calculate(input);

        OutputView.printResult(result);
    }
}
