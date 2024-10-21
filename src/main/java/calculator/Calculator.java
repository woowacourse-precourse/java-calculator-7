package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calculator {
    /**
     * 주어진 문자열 입력을 파싱하고 숫자들의 합을 계산
     *
     * @param input 쉼표, 콜론, 또는 커스텀 구분자로 구분된 숫자들의 문자열
     * @return 입력된 숫자들의 합
     * @throws IllegalArgumentException 입력에 음수가 포함된 경우
     */

    public static int add(String input) {
        String[] numbers = Parser.parseNumbers(input);
        int sum = 0;

        for (String num : numbers) {
            int n = parseAndValidateNumber(num);
            sum += n;
        }

        return sum;
    }

    /**
     * 문자열을 정수로 파싱하고 유효성을 검사.
     *
     * @param num 파싱할 숫자 문자열
     * @return 파싱된 양의 정수 값
     * @throws IllegalArgumentException 입력이 음수인 경우
     * @throws NumberFormatException 입력을 정수로 파싱할 수 없는 경우
     */

    private static int parseAndValidateNumber(String num) {
        int n = Integer.parseInt(num.trim());
        if (n < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + n);
        }
        return n;
    }
}