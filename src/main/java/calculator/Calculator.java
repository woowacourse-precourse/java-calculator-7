package calculator;

import java.util.List;

public class Calculator {

    private CustomValidator customValidator;
    private InputHandler inputHandler;
    private InputParser inputParser;

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
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputHandler.input();
        customValidator.validate(inputHandler.getInputData());
        List<Integer> numbers = inputParser.parse();
        int result = sum(numbers);
        System.out.printf("결과 : %d", result);
    }
}
