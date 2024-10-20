package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String receiveValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요. Ex)1,2,3 ");
        return Console.readLine();
    }
}
