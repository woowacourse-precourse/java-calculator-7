package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 문자열을 입력받는 view
 */
public class InputView {

    public String getInputString() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getInputStringFromNextLine(String input) {
        input += "\\n" + Console.readLine();

        return input;
    }

}
