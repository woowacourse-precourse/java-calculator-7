package calculator.input;

import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
    private static InputProcessor instance;

    private InputProcessor() {

    }

    public static InputProcessor getInstance() {
        if(instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    public String read() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine().trim();

        if(input.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.EMPTY_INPUT.getValue());
        }

        Console.close();
        return input;
    }

}
