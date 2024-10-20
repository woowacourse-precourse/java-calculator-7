package calculator.parser;

public class DefaultDelimiterParser implements DelimiterParser {

    private static final String DEFAULT_DELIMITERS = "[,|:]";

    /**
     * 기본 구분자를 사용하여 문자열을 분리합니다.
     *
     * @param input 분리할 문자열을 매개변수로 받습니다.
     * @return 파싱된 배열을 반환합니다.
     */
    @Override
    public String[] parse(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}