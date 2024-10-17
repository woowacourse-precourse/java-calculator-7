package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        System.out.println("결과 : " + inputString);

        // 사용이 끝나면 반드시 close() 메서드를 호출하여 자원 해제
        Console.close();

    }
}
