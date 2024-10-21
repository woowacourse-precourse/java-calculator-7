package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public String input() {
        System.out.println("숫자입력 : ");
        return Console.readLine();
    }
}
