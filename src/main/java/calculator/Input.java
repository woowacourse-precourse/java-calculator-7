package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String input() {

        String input = Console.readLine();
        System.out.println("덧셈할 문자열을 입력해 주세요. : " + input);

        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        return input;
    }
}


