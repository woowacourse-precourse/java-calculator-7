package calculator.parser;

public class DelimiterParserFactory {

    /**
     * 입력 문자열이 커스텀 구분자를 사용하는지 확인하고, 적절한 구분자 파서를 반환합니다.
     *
     * @param input 입력 문자열을 매개변수로 받습니다.
     * @return 입력 문자열에 대한 적절한 DelimiterParser 구현체을 반환합니다.
     */
    public DelimiterParser getParser(String input) {
        if (input.startsWith("//")) {
            return new CustomDelimiterParser();
        }
        return new DefaultDelimiterParser();
    }
}