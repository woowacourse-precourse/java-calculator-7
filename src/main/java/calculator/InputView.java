package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // TODO: 입력받은게 빈 문자열이라면?
        return Console.readLine();
    }

}
