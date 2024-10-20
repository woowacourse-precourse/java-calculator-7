package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 사용자로부터 덧셈할 문자열을 입력받는 메서드
     *
     * @return 사용자로부터 입력받은 문자열
     */
    public String inputExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
