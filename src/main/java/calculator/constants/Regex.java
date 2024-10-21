package calculator.constants;

public class Regex {

    // 정수 또는 소수를 나타내는 패턴
    public static final String INTEGER_PART = "[1-9][0-9]*";  // 양의 정수 (1 이상으로 시작하는 숫자)
    public static final String DECIMAL_PART = "(\\.[0-9]+)?";  // 소수점 (선택적)
    public static final String ZERO_DECIMAL = "0\\.[0-9]+";    // 소수 (1 미만)
    // 양수 = 모든 소수 or 모든 정수
    public static final String POSITIVE_NUMBER_PATTERN = ZERO_DECIMAL + "|" + INTEGER_PART + DECIMAL_PART;

    // 커스텀 구분자 패턴
    public static final String CUSTOM_DELIMITER_PREFIX = "//";  // 커스텀 구분자의 시작 (//)
    public static final String DELIMITER_CONTENT = "([\\s\\S]+?)";  // 실질적 구분자 (모든 문자 1개 이상)
    public static final String NEWLINE_PATTERN = "\\\\n";  // 문자 그대로의 줄바꿈 (\n)
    // 커스텀 구분자 포함 시, 입력 숫자 패턴 - 양수로 시작 + 모든 문자
    public static final String NUMBER_CONTENT_PATTERN = "(^" + POSITIVE_NUMBER_PATTERN + "[\\s\\S]*$)";

    // 커스텀 구분자 패턴
    public static final String CUSTOM_DELIMITER_PATTERN = CUSTOM_DELIMITER_PREFIX
            + DELIMITER_CONTENT
            + NEWLINE_PATTERN
            + NUMBER_CONTENT_PATTERN;

    // 기본 구분자
    public static final String DELIMITER = "[,:]";
}