package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputString {

    // 사용자 입력 메서드
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); //전체 줄 입력
    }

}
