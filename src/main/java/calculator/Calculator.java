package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public void run() {
        //1. 문자열 입력받기
        String str = getString();

        //구분자 문자열
        String separator = "";

        if (Custom(str)) { //2. 커스텀 구분자

        } else { //커스텀 구분자가 아닌 문자열들

        }

    }

    private static String getString() {
        System.out.println(inputMessage);
        return Console.readLine();
    }

    //2. 커스텀 문자열 확인
    private boolean Custom(String str) {
        //문자열 길이가 1보다 작은 경우 false를 반환하는 조건이 있는 이유는 substring(0,2)에서 오류가 발생하기 때문에 미리 처리
        if (str.length() <= 1) {
            return false;
        }
        return str.startsWith("//") && str.startsWith("\\n", 3);
    }

}
