package calculator.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;

public class InputHandler {

    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public Optional<String> input() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        String input = Console.readLine();
        return processInput(input);
    }

    private Optional<String> processInput(String input) {
        if (input == null || input.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(input.trim().replace("\\n", "\n"));
    }
}
