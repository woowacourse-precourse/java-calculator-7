package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }
}
