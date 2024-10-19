package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해주세요.");

        String str = camp.nextstep.edu.missionutils.Console.readLine();

        int ans = 0;
        ans = summarize(str);
        System.out.println("결과 : " + ans);
    }
}