package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        DelimiterParser delimiterParser = new DelimiterParser();
        StringCalculator calculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 커스텀 구분자와 나머지 문자열 추출
        String customDelimiter = DelimiterParser.getDelimiter(input);
        String numbers = DelimiterParser.getRamainString(input);

        // StringCalculator에 커스텀 문자와 문자열을 넘겨 합 계산
        int result = calculator.add(numbers, customDelimiter);

        System.out.println("결과 : " + result);
    }
}


