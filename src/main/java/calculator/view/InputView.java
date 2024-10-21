package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String strInput() {
        System.out.println(Constant.ENTER_STR);
        return Console.readLine();
    }
}