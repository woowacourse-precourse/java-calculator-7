package calculator;

public class DelimiterParser {

    private static final String DEFAULT_DELIMITERS = ",:";

    // 기본 구분자만 처리하는 임시 메서드
    public static String[] split(String input) {
        return input.split("[" + DEFAULT_DELIMITERS + "]");
    }
}
