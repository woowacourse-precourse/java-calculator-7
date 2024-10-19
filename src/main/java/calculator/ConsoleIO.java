package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIO {

    private ConsoleIO() {
        // 인스턴스 생성 방지
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
