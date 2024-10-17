package calculator.domain.calculator.domain;

public class Delimiter {
    private static final String DEFAULT_PATTERN = "[,:]";
    private final String pattern;

    public Delimiter() {
        this.pattern = DEFAULT_PATTERN;
    }

    private Delimiter(String pattern) {
        this.pattern = validateDelimiter(pattern);
    }

    public static Delimiter of(
            final String pattern
    ) {
        return new Delimiter(pattern);
    }

    /*
    TO-DO: util 클래스로 나중에 옮겨야함
     */
    public static Delimiter parse(String input) {
        boolean startsWithCustom = input.startsWith("//");
        if (startsWithCustom) {
            int lastIndex = input.indexOf("\n");

            if (lastIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 닫는 문자가 없습니다.");
            }

            String customDelimiter = input.substring(2, lastIndex);
            return new Delimiter(customDelimiter);
        }

        return new Delimiter();
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
