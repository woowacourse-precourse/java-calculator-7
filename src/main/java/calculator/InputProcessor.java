package calculator;

public class InputProcessor {
    private InputProcessor() {
        //인스턴스 생성 불가
    }
    
    static public NumberTokens process(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters delimiters = delimiterExtractor.extractDelimiters(input);
        String numbersPart = delimiterExtractor.getNumbersPart();
        String[] tokens = TokenSplitter.split(numbersPart, delimiters);
        return TokenParser.parseTokens(tokens, delimiters.containsDotDelimiter());
    }
}
