package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");  // 사용자가 입력한 "\\n"을 실제 개행 문자로 변환
        try {
            ParsingStrategy strategy = ParsingStrategyFactory.getStrategy(input);
            int result = strategy.parse(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
