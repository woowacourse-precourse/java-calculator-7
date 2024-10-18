package calculator.view;

import calculator.domain.Number;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<Number> readNumbers() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        int index = inputHandler.isCustomDelimiter(input);
        input = input.substring(index);
        return inputHandler.parseNumbers(input);
    }
}
