package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = getInput(); // 문자열 입력 받기
    }

    private static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요: ");
        String input = Console.readLine();
        return input;
    }

}
