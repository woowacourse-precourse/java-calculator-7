package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 사용자의 입력을 받는 메소드
     *
     * @return 사용자의 입력
     */
    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 문자열을 입력받고, Console을 닫는 메소드
     */
    public void close() {
        Console.close();
    }
}
