package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

    }
}