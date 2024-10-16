package calculator.object;

import java.math.BigDecimal;
import java.util.List;

public record CalculateFormula(
        String customSeparator,
        List<BigDecimal> numbers
) {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

}
