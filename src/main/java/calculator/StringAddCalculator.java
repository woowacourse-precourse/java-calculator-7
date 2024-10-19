package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int calculate(String input) {
        // 입력 값이 없을 경우
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiters = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            //group 메소드 확인하고 공부 하기
            Pattern customDelimiterPattern = Pattern.compile("^//([^0-9])\\\\n(.*)");
            Matcher matcher = customDelimiterPattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("커스텀 구분자를 올바르게 지정해주세요.");
            }
            delimiters += "|" + matcher.group(1);
            numbers = matcher.group(2);
        }

        String[] result = numbers.split(delimiters);

        int sum = 0;
        for (String token : result) {
            int number = Integer.parseInt(token);
            sum += number;
        }
        return sum;
    }

}
