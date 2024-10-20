package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        TokenSplitter splitter = new TokenSplitter();
        String[] tokens = splitter.split(input);

        StringCalculator calculator = new StringCalculator();
        int result = calculator.sumTokens(tokens);

        System.out.println("결과 : " + result); // 합산 결과 출력
    }

}
