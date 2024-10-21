package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_STRING_TO_ADD = "덧셈할 문자열을 입력해 주세요.";

    private static String inputString(){
        System.out.println(INPUT_STRING_TO_ADD);
        return Console.readLine();
    }
}
