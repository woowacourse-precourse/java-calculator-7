package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getString() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }

}
