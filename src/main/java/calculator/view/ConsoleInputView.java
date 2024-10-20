package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String readLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
