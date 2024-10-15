package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_VIEW = "덧셈할 문자열을 입력해 주세요.";

    public static String readInputString() {
        System.out.println(INPUT_VIEW);
        return Console.readLine().trim();
    }
}
