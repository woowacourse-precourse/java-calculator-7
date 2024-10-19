package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String USER_NUMBERS = "덧셈할 문자열을 입력해 주세요.";
    private static final String INVALID_INPUT = "입력이 잘못되었습니다.";

    public String readUserNumbers() {
        System.out.print(USER_NUMBERS);
        System.out.print("\n");
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return input;
    }

}
