package calculator.domain.calculator.domain;

public class Delimiter {
    private static final String DEFAULT_PATTERN = "[,:]";
    private final String pattern;

    private Delimiter(String pattern) {
        this.pattern = validateDelimiter(pattern);
    }

    public static Delimiter of(
            final String pattern
    ) {
        return new Delimiter(pattern);
    }

    private String validateDelimiter(String pattern) {
        /*
        TO-DO: 이 부분은 예외를 발생 시키고 시스템 종료 시켜도 상관없어 보이지만 체크
         */
        if (pattern.isEmpty()) {
            return DEFAULT_PATTERN;
        }

        return pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
