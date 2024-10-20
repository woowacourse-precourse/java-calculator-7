package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class Application {
    private static long sum;

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        try {
            HashSet<String> delimiters = new HashSet<>();
            String processedString = CalculaterSeparator.process(input, delimiters);
            sum = CalculaterSum.calculateSum(processedString, delimiters);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
