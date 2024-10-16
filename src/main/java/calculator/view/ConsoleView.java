package calculator.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class ConsoleView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return readLine();
    }
}
