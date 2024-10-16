package calculator;

import calculator.view.InputView;

import java.util.List;

public class StringSumCalculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputValue = InputView.getInputValue();
        IntegersExtractor integersExtractor = new IntegersExtractor();
        List<Integer> integers = integersExtractor.extractIntegers(inputValue);
        int sum = getSum(integers);
        System.out.println("결과 : " + sum);
    }

    private int getSum(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }
}
