package calculator;

import java.util.regex.Pattern;

public class Calculator {

    public static int add(String input) {

        // 빈 입력에 대한 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delim = ",|:";
        String numbers = input;

        // 커스텀 연산자 추출
        if (input.startsWith("//")) {
            int point = input.indexOf("\\n");

            String customDelim = input.substring(2, point);
            delim += "|" + Pattern.quote(customDelim);
            numbers = input.substring(point + 2);
        }


        // 구분자로 숫자 분리 및 덧셈
        String[] tokens = numbers.split(delim);
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;
    }

}
