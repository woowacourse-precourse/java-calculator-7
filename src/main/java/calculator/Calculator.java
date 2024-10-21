package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    // 문자열 입력 받기
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 기본 구분자와 커스텀 구분자 구분하기
    public static boolean checkCustomDelimiter(String str) {
        return str.startsWith("//");
    }
}
