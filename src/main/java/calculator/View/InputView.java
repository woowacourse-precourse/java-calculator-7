package calculator.View;
import camp.nextstep.edu.missionutils.Console;

import static calculator.Constants.ViewConstants.START;

public class InputView {
    public static String userInput(){
        System.out.println(START.getMessage());
        return Console.readLine();
    }
}
