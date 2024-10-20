package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;

        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String userInputStr = Console.readLine();

        String delimiter = userInputStr.substring(2, userInputStr.indexOf("\\n"));
        System.out.println("delimiter = " + delimiter);
    }
}