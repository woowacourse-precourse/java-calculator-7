package calculator;

public class Calculator {
    public int sum(String input){
        DelimiterExtractor extractor = new DelimiterExtractor(input);
        String delimiter = extractor.getDelimiter();
        String numbers = extractor.getNumbers();
        // TODO : sum 구현하기
        return 0;
    }
}