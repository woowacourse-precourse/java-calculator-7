package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCalculationString() {
        return Console.readLine();
    }
}
