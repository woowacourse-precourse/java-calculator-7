package calculator.strategy;

public class DefaultCalcDelimiterStrategy extends AbstractCalcDelimiterStrategy {
    private static final String DELIMITER_REGEX = "[,:/]";

    @Override
    public Integer[] splitNumbers(String expression) {
        return processNumbers(expression, DELIMITER_REGEX);
    }
}
