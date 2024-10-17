package calculator;

/**
 * 입력받은 문자열을 파싱하는 클래스.
 */
public class Parser {
    private static final char COMMA = ',';
    private static final char SEMICOLON = ':';
    private static final String STANDARD_SEPARATOR_REGEX = "[" + COMMA + SEMICOLON + "]";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private int result = 0;

    public Parser(String strToParse) {
        if (isCustomSeparator(strToParse)) {
            // TODO: Implement custom separator parsing
            // 커스텀 구분자 처리
            // parseCustomSeparator(strToParse);
        } else {
            // 기본 구분자를 사용한 문자열 파싱
            parseStandardSeparator(strToParse);
        }
    }

    private void addNumToResult(int num) {
        try {
            /* Integer Overflow 체크 */
            result = Math.addExact(result, num);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("범위 초과.");
        }
    }

    private boolean isCustomSeparator(String str) {
        return str.matches(CUSTOM_SEPARATOR_REGEX);
    }

    /* 기본 구분자 파싱 프로시저 */
    private void parseStandardSeparator(String str) {
        String[] parsedStr = str.split(STANDARD_SEPARATOR_REGEX);

        for (String s : parsedStr) {
            int num;
            /* 빈 문자열이면 무시 */
            if (s.isBlank()) {
                continue;
            }

            try {
                //구분자로 분리된 문자열을 숫자로 변환
                num = Integer.parseInt(s);
                if (num <= 0) {
                    throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 값이 포함되어 있습니다.");
            }
            // 변환된 숫자들의 합계 계산
            addNumToResult(num);
        }
    }

    public int getResult() {
        return result;
    }

}
