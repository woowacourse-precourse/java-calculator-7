package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser implements DelimiterParser {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    /**
     * 커스텀 구분자를 사용하여 문자열을 분리합니다.
     *
     * @param input 분리할 문자열을 매개변수로 받습니다.
     * @return 파싱된 배열을 반환합니다.
     * @throws IllegalArgumentException 잘못된 커스텀 구분자 형식일 경우 예외 발생시킵니다.
     */
    @Override
    public String[] parse(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }
}