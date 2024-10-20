package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        InputParser parser = new InputParser();
        ParsedInput parsedInput = parser.parse(input);

        TokenSplitter splitter = new TokenSplitter();
        String[] tokens = splitter.split(parsedInput.getInput(), parsedInput.getDelimiter());

        StringCalculator calculator = new StringCalculator();
        int result = calculator.sumTokens(tokens);

        System.out.println("결과 : " + result); // 최종 결과 출력
    }

}
