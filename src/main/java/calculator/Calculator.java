package calculator;

import calculator.util.DelimiterExtractor;
import calculator.util.InputConverter;
import calculator.view.InputView;

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

    }
}
