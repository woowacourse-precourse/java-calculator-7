package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readString(){
        return InputValidation.readStringValidation(Console.readLine());
    }
}
