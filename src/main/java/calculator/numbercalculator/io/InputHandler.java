package calculator.numbercalculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final int MAX_INPUT_LENGTH = 100;

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validateInputLength(input);
        return input;
    }

    public void validateInputLength(String input) {
        int length = input.length();
        if (length > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(String.format("덧셈할 문자열은 %d자리 이하여야 합니다.", MAX_INPUT_LENGTH));
        }
    }
}
