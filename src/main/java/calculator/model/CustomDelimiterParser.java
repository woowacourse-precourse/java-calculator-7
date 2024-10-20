package calculator.model;

public interface CustomDelimiterParser {

    String parse(String input);

    boolean isNumeric(String strNum);
}
