package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] split(String input) {
        // 빈 문자열이면 그대로 리턴해서 리턴값을 나중에 따로 처리
        if (input.isEmpty()) {
            return new String[0];
        }

        String delimiter = DEFAULT_DELIMITER;
        String values = input;

        Pattern customDelimiterPattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(input);
        // 완벽하게 일치하는 지 확인
        if (matcher.matches()) {
            String customDeilimiter = matcher.group(1);
            // 음수 기호 및 숫자 제외
            if (!"-".equals(customDeilimiter) && !customDeilimiter.matches("\\d")) {
                delimiter += "|" + customDeilimiter;
                values = matcher.group(2);
            }
        }

        return values.split(delimiter);
    }
}
