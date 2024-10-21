package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요:");

        // 첫 번째 입력: 구분자 입력
        String delimiterInput = Console.readLine();

        // 두 번째 입력: 숫자 입력
        String numberInput = Console.readLine();

        // 두 줄의 입력을 결합하여 반환
        return delimiterInput + "\n" + numberInput;
    }
}
