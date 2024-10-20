package calculator.view;

import static calculator.exception.ExceptionMessage.INPUT_IS_BLANK;

import calculator.exception.InputBlankException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT = "덧셈할 문자열을 입력해 주세요.";
    public static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public String read() {
        System.out.println(PROMPT);
        String input = Console.readLine().trim();
        if (input.isBlank()) {
            throw new InputBlankException(INPUT_IS_BLANK);
        }
        Console.close();
        return input;
    }
}
