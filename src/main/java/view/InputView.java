package view;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;

public class InputView {

    public static String inputString(){
        System.out.println(Constants.NOTICE_INPUT_CONTEXT);
        return Console.readLine();
    }
}
