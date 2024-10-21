package calculator;

public class DelimiterExtractor {
    private Delimiters delimiters;
    private String numbersPart;
    
    public DelimiterExtractor() {
        this.delimiters = Delimiters.createDefault();
    }
    
    public Delimiters extractDelimiters(String input) {
        int currentIndex = 0;
        while (input.startsWith("//", currentIndex)) {
            int delimiterStart = currentIndex + 2;
            int delimiterEnd = input.indexOf("\\n", delimiterStart);
            if (delimiterEnd == -1 || delimiterEnd == delimiterStart) {
                throw new IllegalArgumentException("올바르지 않은 구분자 지정입니다.");
            }
            String customDelimiterStr = input.substring(delimiterStart, delimiterEnd);
            Delimiter customDelimiter = new Delimiter(customDelimiterStr);
            delimiters.add(customDelimiter);
            currentIndex = delimiterEnd + 2;
        }
        numbersPart = extractNumbersPart(input, currentIndex);
        return delimiters;
    }
    
    private String extractNumbersPart(String input, int startOfNumberPart) {
        return input.substring(startOfNumberPart);
    }
    
    public String getNumbersPart() {
        return numbersPart;
    }
    
}
