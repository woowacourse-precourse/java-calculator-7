package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView() {
    }

    public static String inputString() {
        String inputString = Console.readLine();
        // 검증
        return inputString;
    }

}
