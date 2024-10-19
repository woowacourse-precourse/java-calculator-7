package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        checkNullInput(input);

        return input;
    }

    private void checkNullInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 입력값");
        }
    }
}
