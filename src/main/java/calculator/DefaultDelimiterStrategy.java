package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    @Override
    public String[] splitNumbers(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

    @Override
    public boolean matches(String input) {
        // 사용자 정의 구분자 "//"가 아닌 경우 기본 구분자 전략을 사용
        return !input.startsWith("//");
    }
}
