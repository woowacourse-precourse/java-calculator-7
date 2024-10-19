package calculator;

public class DefaultParser implements Parser {

    private final DelimiterParser delimiterParser;

    public DefaultParser(String input) {
        delimiterParser = new DelimiterParser(input);
    }

    @Override
    public String[] parse() {

        // 구분자 처리 로직 (DelimiterParser와 DelimiterStrategy 사용)
        String numbersPart = delimiterParser.getNumbersPart(); // 숫자 부분 추출
        DelimiterStrategy delimiterStrategy = delimiterParser.getDelimiterStrategy(); // 구분자 전략

        return delimiterStrategy.split(numbersPart); // 구분자에 따라 문자열 분리
    }
}
