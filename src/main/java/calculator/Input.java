package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.: ");  // 사용자에게 입력 요청 메시지 출력
        return Console.readLine();  // 사용자 입력을 받아 반환 (한 줄의 문자열 반환)
    }

}
