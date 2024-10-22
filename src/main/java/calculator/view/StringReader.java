package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class StringReader {

    private final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String read() {
        System.out.println(MESSAGE);

        String input = "";
        try {
            input = Console.readLine();
        } catch (NoSuchElementException ignored) {
            // 아무런 값도 입력하지 않았을 때, 기본 값 ""을 반환합니다.
        }
        return input;
    }
}
