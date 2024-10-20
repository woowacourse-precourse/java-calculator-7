package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 문자열을 입력받는 클래스입니다.
 */
public class Input {

    /**
     * 문자열 입력
     */
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
