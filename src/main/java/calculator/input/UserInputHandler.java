package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

    public String userInput() {
        System.out.println("계산할 식을 입력해주세요.");
        return Console.readLine();
    }
}
