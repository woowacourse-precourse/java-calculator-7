package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 덧셈할 문자열 입력받는 함수
     * **/
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요 : ");
        return Console.readLine();
    }
}
