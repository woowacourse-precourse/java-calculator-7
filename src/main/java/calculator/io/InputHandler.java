package calculator.io;

import calculator.InputString;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public InputString getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        return new InputString(inputString);
    }
}
