package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringSumCalculator {
    private final IntegersExtractor integersExtractor;

    public StringSumCalculator(IntegersExtractor integersExtractor) {
        this.integersExtractor = integersExtractor;
    }

    public void run() {
        String inputValue = InputView.getInputValue();
        List<Integer> integers = integersExtractor.extractIntegers(inputValue);
        int result = getSum(integers);
        OutputView.showResultMessage(result);
    }

    private int getSum(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }
}
