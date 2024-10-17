package calculator;

import camp.nextstep.edu.missionutils.Console;

// 사용자의 문자열 입력을 책임지는 클래스
public class InputHandler {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 예외처리 추가하기

        return input;
    }

}
