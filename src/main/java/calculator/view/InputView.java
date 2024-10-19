package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    //TODO: input이 null인 경우 예외처리

    public String readStringToAdd() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine().trim();
    }
}
