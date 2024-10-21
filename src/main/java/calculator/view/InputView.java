package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    public String getInput() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String input = Console.readLine();
            if (input.isBlank()) {
                System.out.println("빈 문자열을 입력했습니다.");
                return "";
            }
            return input;
        } catch (NoSuchElementException e) {
            return "";
        }
    }

}
