package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterService {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    // 구분자와 숫자를 한 번에 처리하는 메서드
    public List<String> processInputAndExtractNumbers(String input) {
        String[] lines = input.split("\\\\n");
        String delimiterPattern = getDefaultDelimiterPattern();

        if (lines.length == 2) {
            delimiterPattern = getCustomDelimiterPattern(lines[0]);
            return Arrays.asList(lines[1].split(delimiterPattern));
        }

        return Arrays.asList(lines[0].split(delimiterPattern));

    }

    // 커스텀 구분자를 추출하고 정규식 패턴으로 반환하는 메서드
    private String getCustomDelimiterPattern(String customDelimiterLine) {
        // 커스텀 구분자 형식 체크
        if (!customDelimiterLine.startsWith("//") || customDelimiterLine.length() != 3) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        char customDelimiter = customDelimiterLine.charAt(2);

        // 구분자가 숫자일 수 없음
        if (Character.isDigit(customDelimiter)) {
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
        }

        // 커스텀 구분자를 정규식 패턴으로 반환
        return Pattern.quote(String.valueOf(customDelimiter));
    }

    // 기본 구분자 반환 메서드
    // 쉼표와 콜론을 합쳐서 정규식 패턴으로 반환하는 메서드
    private String getDefaultDelimiterPattern() {
        return Pattern.quote(COMMA) + "|" + Pattern.quote(COLON);
    }
}