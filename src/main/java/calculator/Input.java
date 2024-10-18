package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.: ");  // 사용자에게 입력 요청 메시지 출력
        String string = Console.readLine();  // camp.nextstep.edu.missionutils.Console을 이용하여 사용자로부터 한 줄의 문자열 입력 받기
        System.out.println(string);
        return string;
    }

}
