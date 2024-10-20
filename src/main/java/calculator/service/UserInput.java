package calculator.service;

import calculator.model.Global;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class UserInput {

    private final Global global;

    public UserInput() {
        this.global = Global.getInstance();
    }

    public void readLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String input = Console.readLine();
            global.setInput(input);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }
}
