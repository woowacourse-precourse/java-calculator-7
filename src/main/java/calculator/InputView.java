package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView extends InputValidator{
    public String input() {
        String given = readLine();
        // 예외처리
        return given;
    }
}
