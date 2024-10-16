package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String ZERO = "0";

    public String input() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        String input = Console.readLine();
        return processInput(input);
    }

    public String processInput(String input) {
        if (input == null || input.isBlank()) {
            return ZERO;
        }
        return input.trim();
    }
}
