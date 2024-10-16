package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String inputString;

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputString = Console.readLine();
        return inputString;
    }
}
