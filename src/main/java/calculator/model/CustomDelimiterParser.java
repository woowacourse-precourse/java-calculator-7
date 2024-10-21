package calculator.model;

public interface CustomDelimiterParser {

    String parse(String input);

    String getString(String input, int customDelimiterStart, int customDelimiterEnd);

    boolean isNumeric(String strNum);
}
