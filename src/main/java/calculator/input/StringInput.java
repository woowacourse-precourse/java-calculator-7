package calculator.input;

import static calculator.validate.StringValidate.validateNotNullInput;

import camp.nextstep.edu.missionutils.Console;

public class StringInput {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validateNotNullInput(input);
        return input;
    }
}

