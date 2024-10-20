package calculator.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private final static String INPUT_MESSAGE= "덧셈할 문자열을 입력해 주세요";

    public static String getExpression() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

}
