package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isBlank()) {
            return "0";
        }
        validate(input);
        return input;
    }

    private void validate(String input) {

        // 숫자, 콤마, 콜론, 또는 커스텀 구분자만 허용
        if (!input.matches("(//.+)?[0-9]+([,:][0-9]+)*") && !input.matches("//.+\\n[0-9]+(.*)")) {
            throw new IllegalArgumentException("(잘못된 입력) 입력형식을 지켜주세요. 예) \"1,2\" \"1,2,3\" \"1,2:3\" \"//;\\n1;2;3\"");
        }

        // 숫자만 입력된 경우 예외 처리 (구분자가 없는 경우)
        if (input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("(잘못된 입력) 숫자만 입력되었습니다. 구분자와 함께 입력하세요. 예) \"1,2\" \"1,2,3\" \"1,2:3\" \"//;\\n1;2;3\"");
        }
    }
}
