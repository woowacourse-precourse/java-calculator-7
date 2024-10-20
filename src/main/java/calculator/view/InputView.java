package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        String input = Console.readLine();
        Console.close();
        return input;
    }

}
