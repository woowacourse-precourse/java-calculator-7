package calculator;

/**
 * 입력받은 문자열을 파싱하는 클래스.
 */
public class Parser {
    private static final char COMMA = ',';
    private static final char SEMICOLON = ':';
    private static final String STANDARD_SEPARATOR_REGEX = "[" + COMMA + SEMICOLON + "]";
    private static final String CUSTOM_SEPARATOR_REGEX_PATTERN = "^//(.)\\\\n(.*)";
    private final String strToParse;
    private int result = 0;

    public Parser(String strToParse) {
        this.strToParse = strToParse;
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
        return str.matches(CUSTOM_SEPARATOR_REGEX_PATTERN);
    }


    private int tryParseInt(String s) {
        try {
            //구분자로 분리된 문자열을 숫자로 변환
            int num = Integer.parseInt(s);
            if (num <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값이 포함되어 있습니다.");
        }
    }

    public int getResult() {
        return result;
    }

    private boolean isSpecialChar(char c) {
        return switch (c) {
            case '.', '*', '+', '?', '^', '$', '|', '\\', '(', ')' -> true;
            default -> false;
        };
    }

    private String sanitizeSeparator(char c) {
        if (isSpecialChar(c)) {
            return "\\" + c;
        }
        return Character.toString(c);
    }

    public void parse() {
        if (isCustomSeparator(strToParse)) {
            parseCustomSeparator(strToParse);
        } else {
            parseStandardSeparator(strToParse);
        }
    }

    private void parseCustomSeparator(String str) {
        // "//" 와 '\n' 사이의 문자를 커스텀 구분자로 인식
        char separator = str.charAt(2);
        // regex 특수문자 처리
        String cleanSeparator = sanitizeSeparator(separator);

        // 커스텀 구분자를 제외한 문자열
        String strNoSeparator = str.substring(5);

        // 커스텀 구분자를 사용하여 문자열 분리
        String[] parsedStr = strNoSeparator.split(cleanSeparator);
        calculateSum(parsedStr);
    }


    /* 기본 구분자 파싱 프로시저 */
    private void parseStandardSeparator(String str) {
        String[] parsedStr = str.split(STANDARD_SEPARATOR_REGEX);
        calculateSum(parsedStr);
    }

    private void calculateSum(String[] parsedStr) {
        for (String s : parsedStr) {
            /* 빈 문자열이면 무시 */
            if (s.isBlank()) {
                continue;
            }

            int num = tryParseInt(s);
            // 변환된 숫자들의 합계 계산
            addNumToResult(num);
        }
    }
}
