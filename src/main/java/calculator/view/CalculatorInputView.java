package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView implements InputView {

    @Override
    public String inputString() {
        return Console.readLine();
    }
}
