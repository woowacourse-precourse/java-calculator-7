package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class stringInput {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return validateInput(input);
    }

    public static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
        if (!input.startsWith("//")) {
            throw new IllegalArgumentException("문자열은 '//'로 시작해야 합니다.");
        }
        if (!input.contains("\n")) {
            throw new IllegalArgumentException("문자열에 '\n'이 있어야 합니다.");
        }
        return input;
    }

}

