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
            //3. 커스텀 구분자 중 [,\,] 세가지인 경우 구분자 조정
            String a = ConvertSeparator(String.valueOf(str.charAt(2)));
            //구분자를 separator에 추가
            separator = "[,:".concat(a).concat("]");
            //계산에 필요한 문자열만 잘라줌
            str = str.substring(5);
        } else { //커스텀 구분자가 아닌 문자열들
            separator = "[,:]"; //구분자 아니면 구분자[,:]로!
        }

    }

    //1. 사용자의 입력을 받는 메서드
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

    // 3. 구분자가 [, \, ] 인 경우 구분자 조정
    private static String ConvertSeparator(String a) {
        switch (a) {
            case "\\" -> a = "\\\\";
            case "[" -> a = "\\[";
            case "]" -> a = "\\]";
        }
        return a;
    }

}
