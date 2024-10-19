package calculator.global.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor extends DelimiterExtractor {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    private static final String NUMBERS_PART = "$2"; // 숫자 부분을 나타내는 상수

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private String extractDelimiter(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    @Override
    public Integer[] extractNumber(String input) {
        String delimiter = extractDelimiter(input);
        String numbersPart = input.replaceFirst(CUSTOM_DELIMITER_REGEX, NUMBERS_PART); // 숫자 부분만 추출
        return Arrays.stream(numbersPart.split(delimiter)) // 구분자를 사용하여 분리
                .map(String::trim) // 공백 제거
                .filter(numStr -> !numStr.isEmpty()) // 빈 문자열 필터링
                .map(Integer::parseInt) // 문자열을 정수로 변환
                .toArray(Integer[]::new); // Integer 배열로 변환
    }

    @Override
    public boolean isApplicable(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

}
