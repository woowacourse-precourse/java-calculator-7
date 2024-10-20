package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        TokenSplitter splitter = new TokenSplitter();
        String[] tokens = splitter.split(input);

        for (String token : tokens) {
            System.out.println(token); // 분리된 토큰 출력 (디버깅용)
        }
    }
}
