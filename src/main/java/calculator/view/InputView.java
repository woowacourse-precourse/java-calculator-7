package calculator.view;

import calculator.util.StringValidator;
import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {
    public static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        StringValidator.validate(input);

        return input;
    }
}