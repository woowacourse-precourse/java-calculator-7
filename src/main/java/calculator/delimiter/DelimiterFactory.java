package calculator.delimiter;

import calculator.calculator.Delimiter;
import calculator.utils.ErrorMessage;

public class DelimiterFactory {

    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    private final RegularDelimiter regularDelimiter = new RegularDelimiter();

    private final DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

    public Delimiter getDelimiter(String rawInput) {
        // 커스텀 먼저 반드시 확인되어야 한다.
        if (customDelimiter.applicable(rawInput)) {
            return customDelimiter;
        }

        if (regularDelimiter.applicable(rawInput)) {
            return regularDelimiter;
        }

        if (defaultDelimiter.applicable(rawInput)) {
            return defaultDelimiter;
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
    }
}
