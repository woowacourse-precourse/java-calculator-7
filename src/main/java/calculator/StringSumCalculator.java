package calculator;

import java.util.List;

public class StringSumCalculator {
    public void run() {
        String inputString = InputHandler.inputString();

        StringParser stringParser = new StringParser(inputString);
        List<Integer> numbers = stringParser.extractNumbers();
        int result = sum(numbers);

        OutputHandler.printResult(result);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
