package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 문자열을 입력 받아 저장한다.
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = Console.readLine();
        Console.close();

        // 문자열에서 커스텀 구분자를 추출할 수 있다.
        DelimiterParser delimiterParser = new DelimiterParser();
        delimiterParser.parseDelimiters(inputString);

        System.out.println("Delimiters: " + delimiterParser.getDelimiters());
        System.out.println("ValueString: " + delimiterParser.getValueString());
    }
}
