package calculator;

import java.util.List;

public class StringSumCalculator {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static InputHandler inputHandler;

    StringSumCalculator() {
        inputHandler = new InputHandler();
    }

    public void run() {
        System.out.println(START_MESSAGE);

        String inputString = inputHandler.inputString();
        List<Integer> numbers = inputHandler.extractNumbers(inputString);
        int result = sum(numbers);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
