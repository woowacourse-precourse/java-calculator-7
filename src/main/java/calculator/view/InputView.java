package calculator.view;

import calculator.helper.InputHelper;
import calculator.util.NumCalculatorValidCheck;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputAddStr() {
        OutputView.requestCalStr();
        String input = Console.readLine();
        if(!NumCalculatorValidCheck.isValid(input)) throw new IllegalArgumentException();
        return input;
    }

}
