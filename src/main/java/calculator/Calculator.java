package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    // 문자열 입력 받기
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
