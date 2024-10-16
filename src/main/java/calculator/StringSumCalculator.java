package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringSumCalculator {

    public void run() {
        String inputValue = InputView.getInputValue();
        IntegersExtractor integersExtractor = new IntegersExtractor();
        List<Integer> integers = integersExtractor.extractIntegers(inputValue);
        int result = getSum(integers);
        OutputView.showResultMessage(result);
    }

    private int getSum(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }
}
