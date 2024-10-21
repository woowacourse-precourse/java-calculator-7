package calculator.input;

import calculator.data.InputString;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {

    public static InputString getInputString(){
        String inputString = readLine();
        close();
        return InputString.of(inputString);
    }
}
