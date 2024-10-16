package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}


class Machine {
    public Machine() {
    }

    private static String getString() {
        String input;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        return input;
    }

    public static void printResult(int data) {
        System.out.printf("결과 : %d", data);
    }
}