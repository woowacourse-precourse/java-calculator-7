package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        /* todo : I/O 작동 확인
        * */
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String testValue = Console.readLine();
        System.out.println("결과 : " + testValue);

    }
}

