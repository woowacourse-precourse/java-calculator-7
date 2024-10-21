package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
public class InputView {
    public static String getInput() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
