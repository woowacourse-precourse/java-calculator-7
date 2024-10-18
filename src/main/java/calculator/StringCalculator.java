package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 커스텀 구분자 정규식
    private static final Pattern customDelimiterRegex = Pattern.compile("^//([\\D]+)\\\\n([1-9][0-9]*((\\1|,|:)[1-9][0-9]*)*)$");

    public static int start(String input) {

        // 빈 문자열 검증
        if (input.isBlank()) {
            return 0;
        }

        // 기본 구분자: 쉼표와 콜론
        String delimiter = "[,:]";
        // 커스텀 구분자 확인
        Matcher matcher = customDelimiterRegex.matcher(input);

        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));  // 커스텀 구분자를 추출하여 패턴으로 변경
            input = matcher.group(2);  // 숫자 부분 추출
        }

        // 구분자를 기준으로 문자열 분리
        String[] factors = input.split(delimiter);
        int sum = 0;
        for (String factor : factors) {
            try {
                int number = Integer.parseInt(factor.trim());  // 문자열을 숫자로 변환 (trim을 활용한 공백 제거)
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }

        return sum;
    }

}
