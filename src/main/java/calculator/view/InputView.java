package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInputString() {
        String inputString = Console.readLine();
        Console.close();

        return inputString;
    }


}
