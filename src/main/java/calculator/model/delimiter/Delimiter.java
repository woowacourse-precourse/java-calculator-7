package calculator.model.delimiter;

public interface Delimiter {
    boolean isApplicable(String input);
    String getDelimiter();
    boolean isCustomDelimiter();
}
