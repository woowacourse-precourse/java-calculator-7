package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 덧셈할 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 없을 경우 "결과 : 0" 출력
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        }

        DelimiterParser delimiterParser = new DelimiterParser(input);
        String[] result = delimiterParser.splitString();
        System.out.println(Arrays.toString(result));

        Console.close();
    }
}
