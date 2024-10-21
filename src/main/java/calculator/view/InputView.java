package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String input() {
        String inputString = Console.readLine();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return inputString;
    }

}
