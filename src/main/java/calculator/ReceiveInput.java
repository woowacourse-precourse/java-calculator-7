package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ReceiveInput {
    public String HandlingInput () {  // 문자열을 입력받고, 첫번째 글자로 형식 체크
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input != null && !input.isEmpty()) {
            char firstChar = input.charAt(0);
            if (Character.isDigit(firstChar) || firstChar == '/') {
                return input;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
