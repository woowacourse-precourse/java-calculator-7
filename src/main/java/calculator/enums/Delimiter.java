package calculator.enums;

public enum Delimiter {
    DEFAULT(",|:"),  // 기본 구분자: 쉼표, 콜론
    CUSTOM_PATTERN("//(.)\n(.*)");  // 커스텀 구분자 패턴

    private final String pattern;

    Delimiter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
