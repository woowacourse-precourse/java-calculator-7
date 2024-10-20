package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isBlank()) {
            return "0";
        }
        return input;
    }
}
