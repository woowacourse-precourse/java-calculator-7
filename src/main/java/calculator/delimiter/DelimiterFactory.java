package calculator.delimiter;

import calculator.calculator.Delimiter;

public class DelimiterFactory {

    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    private final RegularDelimiter regularDelimiter = new RegularDelimiter();

    private final DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

    public Delimiter getDelimiter(String input) {
        // 커스텀 먼저 반드시 확인되어야 한다.
        if (customDelimiter.applicable(input)) {
            return customDelimiter;
        }

        if (regularDelimiter.applicable(input)) {
            return regularDelimiter;
        }

        if (defaultDelimiter.applicable(input)) {
            return defaultDelimiter;
        }

        throw new IllegalArgumentException("구분자가 적절하지 않다.");
    }
}
