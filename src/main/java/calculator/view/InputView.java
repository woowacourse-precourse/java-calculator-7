package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 유저의 입력을 받는 메소드
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

}
