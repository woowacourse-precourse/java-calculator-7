package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import static calculator.validator.StringValidator.getValidatedInput;

public class InputView {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        return getValidatedInput(input);
    }
}