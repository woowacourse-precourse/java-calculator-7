package calculator.Delimiter;

public interface Delimiter {
    boolean supports(String input);

    String[] splitStringArray(String input);
}
