package calculator.object;

import java.math.BigDecimal;
import java.util.List;

public record CalculateFormula(
        String customSeparator,
        List<BigDecimal> numbers
) {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    public static CalculateFormula from(String inputFormula) {
        String customSeparator = findCustomSeparator(inputFormula);
        List<BigDecimal> numbers = findNumbers(inputFormula);
        return new CalculateFormula(customSeparator, numbers);
    }

    private static String findCustomSeparator(String inputFormula) {
        if (!inputFormula.contains("//") || inputFormula.indexOf("\n") <= 0) {
            return "";
        }

        String customSeparator = inputFormula.substring(0, inputFormula.indexOf("\n"));
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자가 입력되었습니다.");
        }

        return customSeparator;
    }

}
