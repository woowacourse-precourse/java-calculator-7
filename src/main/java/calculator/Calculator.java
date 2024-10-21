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
            if (point != -1) {
                String customDelim = input.substring(2, point);
                delim += "|" + Pattern.quote(customDelim);
                numbers = input.substring(point + 2);
            }
            else {
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
        }


        // 구분자로 숫자 분리 및 덧셈
        String[] tokens = numbers.split(delim);
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("잘못된 숫자 입력");
                }

                sum += number;
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 입력");
            }
        }

        return sum;
    }

}
