package calculator;

public class DelimiterParser {
    public DelimiterParser(String input) {
        parseValidator(input);
    }

    private void parseValidator(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
    }
}
