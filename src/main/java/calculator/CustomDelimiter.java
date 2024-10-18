package calculator;

public class CustomDelimiter {
    private final char customDelimiter;

    public CustomDelimiter(String customDelimiterString) {
        validateCustomDelimiterLength(customDelimiterString);
        this.customDelimiter = customDelimiterString.charAt(0);
    }

    public char getCustomDelimiter() {
        return customDelimiter;
    }

    private void validateCustomDelimiterLength(String customDelimiterStr) {
        if (customDelimiterStr.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
            throw new IllegalArgumentException();
        }
    }
}
