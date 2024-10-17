package calculator;

public class DelimiterParser {

    private final String input;

    public DelimiterParser(String input) {
        this.input = input;
        parseValidator();
    }

    private void parseValidator() {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            if (newlineIndex <= 2) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
    }
}
