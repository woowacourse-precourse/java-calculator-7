package calculator.io;

import calculator.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    Validation validation = new Validation();

    public String inputText() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String string = Console.readLine();

        validation.isNullOrEmpty(string);
        validation.isCorrectCustomInput(string);
        return string;

    }

}
