package calculator;

import java.util.ArrayList;

public class Calculator {

    private CustomValidator customValidator;
    private InputHandler inputHandler;
    private InputParser inputParser;

    public Calculator() {
        inputHandler = new InputHandler();
        inputParser = new InputParser(inputHandler);
        customValidator = new CustomValidator(inputParser);
    }

    public int sum(ArrayList<Integer> numbers) {
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
        ArrayList<Integer> numbers = inputParser.parse();
        int result = sum(numbers);
        System.out.printf("결과 : %d", result);
    }
}
