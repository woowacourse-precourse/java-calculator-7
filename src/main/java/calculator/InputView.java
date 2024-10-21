package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String input() {
        System.out.print(InfoMessage.INPUT.getMsg());
        String s = Console.readLine();
        Console.close();
        return s;
    }
}
