package calculator.view;

import static calculator.config.SystemConstantMessages.VIEW_CLASS_MESSAGE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private InputView() {
        throw new IllegalStateException(VIEW_CLASS_MESSAGE);
    }

    public static String getUserInput() {
        return readLine();
    }
}
