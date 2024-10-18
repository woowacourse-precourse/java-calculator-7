package calculator.input;

import calculator.validate.StringValidate;
import camp.nextstep.edu.missionutils.Console;

public class StringInput {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return StringValidate.validateInput(input);
    }
}

