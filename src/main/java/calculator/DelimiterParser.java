package calculator;

public class DelimiterParser {

    private final String input;
    private String numbersPart;
    private DelimiterStrategy delimiterStrategy;

    public DelimiterParser(String input) {
        this.input = input;
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            if (newlineIndex <= 2) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            if (input.startsWith("//")) {
                String customDelimiter = input.substring(2, newlineIndex);
                numbersPart = input.substring(newlineIndex + 1);
                delimiterStrategy = new CustomDelimiterStrategy(customDelimiter);
            }
        } else {
            numbersPart = input;
            delimiterStrategy = new DefaultDelimiterStrategy();
        }
    }

    public String getNumbersPart() {
        return numbersPart;
    }

    public DelimiterStrategy getDelimiterStrategy() {
        return delimiterStrategy;
    }
}
