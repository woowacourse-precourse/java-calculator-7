package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private InputView() {
        throw new IllegalStateException("View class");
    }

    public static String getUserInput() {
        return readLine();
    }
}
