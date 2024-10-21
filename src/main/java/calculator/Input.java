package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getInput(){

        String input = Console.readLine();
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
        }
        return input;
    }
}

