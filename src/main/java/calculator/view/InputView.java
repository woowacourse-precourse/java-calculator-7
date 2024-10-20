package calculator.view;

import calculator.util.Constants;
import camp.nextstep.edu.missionutils.Console;

import static calculator.util.Constants.*;

public class InputView {
    public String getInput(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
