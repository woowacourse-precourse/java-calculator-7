package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final String INPUT_STRING_EXPRESSION = "덧셈할 문자열을 입력해 주세요.";

    public String inputString() {
        System.out.println(INPUT_STRING_EXPRESSION);
        return readLine();
    }

}
