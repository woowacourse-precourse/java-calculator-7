package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    private final String INPUT_MSG = "덧셈할 문자열을 입력해 주세요.";

    public String input() {
        System.out.println(INPUT_MSG);
        return inputUserString();
    }

    private String inputUserString() {
        String userInput;
        try {
            userInput = Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }

        return userInput.trim();
    }
}
