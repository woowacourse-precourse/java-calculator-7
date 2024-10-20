package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 view
 */
public class InputView {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
