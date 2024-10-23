package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readString() {
        String s = Console.readLine();
        if(s.isEmpty()) {
            return "0";
        }
        return s;
    }
}
