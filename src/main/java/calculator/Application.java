package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String getInput() {
        printMessage("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static void printMessage(String output) {
        System.out.println(output);
    }

    private static void printError(String errorMessage) {
        System.err.println(errorMessage);
    }

    private static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
