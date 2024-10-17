package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 문자열 입력 받는 함수
     * **/
    public static String input(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
