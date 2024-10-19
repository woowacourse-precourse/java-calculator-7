package calculator;

import calculator.exception.ErrorMessage;
import calculator.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : %d";

    public String readInput() {
        String input = Console.readLine().trim();
        validateString(input);
        return input;
    }

    private void validateString(String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidInputException(input, ErrorMessage.EMPTY_INPUT);
        }
    }

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void printOutputMessage(int result) {
        System.out.printf(OUTPUT_MESSAGE, result);
    }
}
