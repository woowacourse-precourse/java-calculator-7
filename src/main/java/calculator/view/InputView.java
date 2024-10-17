package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readString() {
        String s = Console.readLine();
        if(s.isEmpty()) throw new IllegalArgumentException("[ERROR]덧셈할 문자열을 입력해 주세요");
        return s;
    }
}
