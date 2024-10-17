package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int result = 0;

        PatternParser patternParser = new PatternParser();
        NumberParser numberParser = new NumberParser();

        String[] splitInput = patternParser.splitPattern(input);
        splitInput = numberParser.replaceNumber(splitInput);
        result = numberParser.sumNumber(splitInput);

        System.out.println("결과 : " + result);
    }
}
