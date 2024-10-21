package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    // 실행 함수
    public void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();


        // 출력
        System.out.println("결과: " + str);
    }
}