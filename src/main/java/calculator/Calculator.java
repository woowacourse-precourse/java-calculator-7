package calculator;

import calculator.util.DelimiterExtractor;
import calculator.util.InputConverter;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Calculator {
    protected final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String input = inputView.getInput();

        String extractedInput = DelimiterExtractor.extractDelimiterAndInput(input);
        List<Integer> splitedNumber = InputConverter.convert(extractedInput);
        OutputView.getOutput(numberSum(splitedNumber));
    }

    public int numberSum(List<Integer> splitedNumber) {
        return splitedNumber.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
