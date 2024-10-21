package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IO {

    // 입력
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 주어진 라이브러리를 이용하여 문자열 입력받기
        return Console.readLine();
    }

    // 출력
    public void output(int num) {
        System.out.println("결과 : " + num);
    }
}
