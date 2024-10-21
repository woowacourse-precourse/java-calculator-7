package calculator;

import java.util.List;

public class Calculator {

    private final CustomValidator customValidator;
    private final InputHandler inputHandler;
    private final InputParser inputParser;

    static final String DEFAULT_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    static final String DEFAULT_OUTPUT_MESSAGE = "결과 :";

    public Calculator() {
        inputHandler = InputHandler.getInstance();
        inputParser = new InputParser();
        customValidator = new CustomValidator(inputParser);
    }

    public int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    public void run() {
        System.out.println(DEFAULT_INPUT_MESSAGE);
        inputHandler.input();
        customValidator.validate(inputHandler.getInputData());
        List<Integer> numbers = inputParser.parse();
        int result = sum(numbers);
        System.out.printf("%s %d", DEFAULT_OUTPUT_MESSAGE, result);
    }
}
