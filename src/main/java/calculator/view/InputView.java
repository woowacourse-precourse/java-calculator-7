package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView{

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void print() {
        System.out.println(INPUT_MESSAGE);
    }

    public String getUserInput() {
        return Console.readLine();
    }
}