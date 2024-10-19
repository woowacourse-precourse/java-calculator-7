package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFormatter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\n(.*)", Pattern.DOTALL);

    public String[] splitByDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        input = input.replace("\\n", "\n"); // \n을 바꿔주지 않아서 계속 제대로 구분이 안됐었다 -> 이스케이프 시퀀스 문자를 바꿔줘야함.

        // 커스텀 구분자 추출
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            input = matcher.group(2);

            delimiter += "|" + customDelimiter;
        }

        return input.split(delimiter); // 구분자로 나눠 String 배열로 만듬.
    }
}
