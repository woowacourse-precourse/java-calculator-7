package calculator;

import calculator.model.UserString;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Calculator {

    public int process() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput;
        try {
            userInput = Console.readLine();
        } catch (NoSuchElementException e) {
            return 0;
        }

        if (userInput.trim().isBlank()) {
            return 0;
        }

        UserString userString = new UserString(userInput);
        return userString.sum();
    }
}
