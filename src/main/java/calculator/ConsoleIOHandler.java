package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIOHandler implements AutoCloseable {

    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        return input;
    }

    public void print(Object obj) {
        System.out.println("결과 : " + obj);
    }

    @Override
    public void close() {
        Console.close();
    }
}
