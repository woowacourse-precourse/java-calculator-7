package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 사용자로부터 문자열을 입력받음. -> Console창
     * @return : 사용자로 부터 받은 문자열.
     */

    public String InputString(){
        System.out.println(INPUT);
        return Console.readLine();
    }
}
