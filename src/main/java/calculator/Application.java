package calculator;

import static calculator.presentation.DelimiterConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.presentation.DelimiterConstants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.presentation.DelimiterConstants.DEFAULT_DELIMITER;
import static calculator.presentation.Message.CALCULATOR_INPUT_MESSAGE;
import static calculator.presentation.Message.RESULT_PREFIX;

import calculator.domain.Calculator;
import calculator.presentation.InputView;
import calculator.presentation.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(CALCULATOR_INPUT_MESSAGE, DEFAULT_DELIMITER, CUSTOM_DELIMITER_PREFIX,
                CUSTOM_DELIMITER_SUFFIX);
        OutputView outputView = new OutputView(RESULT_PREFIX);

        Calculator calculator = new Calculator();

        String line = inputView.readInput();
        String[] numbers = inputView.parseInput(line);

        int result = calculator.add(numbers);
        outputView.printResult(result);
    }
}
