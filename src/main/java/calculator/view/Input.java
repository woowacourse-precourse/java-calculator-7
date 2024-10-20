package calculator.view;

import calculator.domain.InputString;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static InputString input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return new InputString(Console.readLine());
    }
}
