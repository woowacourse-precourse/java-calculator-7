package calculator.delimiter;

import calculator.calculator.Delimiter;
import calculator.utils.ErrorMessage;
import java.util.List;

public class DelimiterFactory {

    /**
     * 반드시 Custom -> Regular -> Fallback 순서로 제공되어야 한다.
     */
    private final List<Delimiter> delimiters = List.of(
            new CustomDelimiter(),
            new RegularDelimiter(),
            new FallbackDelimiter()
    );

    public Delimiter getDelimiter(String rawInput) {
        return delimiters.stream()
                .filter(delimiter -> delimiter.applicable(rawInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage()));
    }
}
