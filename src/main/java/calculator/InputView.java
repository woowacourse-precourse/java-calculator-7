package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String inputString(Runnable messagePrinter) {
        messagePrinter.run();
        return readLine();
    }
}

