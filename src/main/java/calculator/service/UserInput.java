package calculator.service;

import calculator.model.Global;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private final Global global;

    public UserInput() {
        this.global = Global.getInstance();
    }

    public void readLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        global.setInput(Console.readLine());
    }
}
