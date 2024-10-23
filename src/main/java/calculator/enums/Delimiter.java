package calculator.enums;

public enum Delimiter {
    DEFAULT(",|:"),  // 기본 구분자: 쉼표, 콜론
    CUSTOM_PATTERN("//(.*?)\\\\?n(.*)");  // \n과 \\n 모두를 지원하는 패턴

    private final String pattern;

    Delimiter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
