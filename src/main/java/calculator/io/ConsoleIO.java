package calculator.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleIO extends IO {

    @Override
    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        } finally {
            Console.close();
        }
        if (input == null || input.isEmpty()) {
            input = "";
        }
        return input;
    }

    @Override
    public void write(String result) {
        System.out.printf("결과 : %s", result);
    }
}
