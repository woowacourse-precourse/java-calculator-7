package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
//        String input = Console.readLine();
//
//        if (input == null || input.trim().isEmpty()) {
//            return "0";
//        }
//        return input;
        return Console.readLine().trim();
    }
}
