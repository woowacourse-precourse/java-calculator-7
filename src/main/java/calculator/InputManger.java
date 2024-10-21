package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManger {
    public InputManger() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String input() {
        return readLine();
    }
}
