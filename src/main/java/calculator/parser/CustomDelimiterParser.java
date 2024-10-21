package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser extends DefaultDelimiterParser {

    //    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\\\n(.*)";

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\\\n(.*)";

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
            String delimiterPart = matcher.group(1);
            String numbers = matcher.group(2);
            if (numbers.contains("-")) {
                throw new IllegalArgumentException("입력값이 음수입니다");
            }
            String customDelimiters = extractDelimiters(delimiterPart);
            String combinedDelimiters = DEFAULT_DELIMITERS.replace("]", customDelimiters + "]");
            return numbers.split(combinedDelimiters);
        }
        throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }

    /**
     * 여러 개의 커스텀 구분자를 추출하고, 이를 정규식으로 결합합니다.
     *
     * @param delimiterPart 커스텀 구분자 문자열을 받습니다.
     * @return 구분자를 정규식으로 결합한 문자열
     */
    private String extractDelimiters(String delimiterPart) {
        String[] delimiters = delimiterPart.split("\\|");
        StringBuilder result = new StringBuilder();
        for (String delimiter : delimiters) {
            result.append("|").append(Pattern.quote(delimiter));
        }
        return result.toString();
    }
}