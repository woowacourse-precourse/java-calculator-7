package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {

    public static InputString getInputString(){
        String inputString = readLine();
        return new InputString(inputString);
    }
}
