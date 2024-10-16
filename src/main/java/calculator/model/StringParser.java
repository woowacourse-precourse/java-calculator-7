package calculator.model;

public class StringParser {

    private static final String BLANK = "";

    public void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public boolean isBlank(String input) {
        return input.equals(BLANK);
    }
}
