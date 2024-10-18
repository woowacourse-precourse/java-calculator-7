package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final Function function = Function.getInstance();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        //기능 수행
        int result = 0;

        if (str.startsWith("//")) {
            result = function.customSeparator(str);
        } else  {
            result = function.isSplit(str);
        }


        System.out.println("결과 : " + result);

    }
}