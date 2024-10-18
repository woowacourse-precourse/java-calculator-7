package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 문자열을 입력 받아 저장한다.
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = Console.readLine();
        Console.close();

        // 문자열에서 커스텀 구분자를 추출할 수 있다.
        DelimiterParser delimiterParser = new DelimiterParser();
        delimiterParser.parseDelimiters(inputString);
        String valueString = delimiterParser.getValueString();
        List<Character> delimiters = delimiterParser.getDelimiters();

        // 문자열을 구분자를 기준으로 분리한 후 덧셈 연산을 할 수 있다.
        int result = Calculator.calculateString(valueString, delimiters);

        System.out.println("result: " + result);
    }
}
