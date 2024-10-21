package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputString {

    public String inputString() {

        String input = Console.readLine();
        System.out.println("입력 값 : " + input);

        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        return input;
    }
}
