package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String askInput() {
        String given = readLine();
        return given;
    }
}
