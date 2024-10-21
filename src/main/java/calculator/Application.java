package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {

        StringHandler stringHandler = new StringHandler();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        int value = stringHandler.checkString(str);

        System.out.println("결과 : " + value);

    }
}
