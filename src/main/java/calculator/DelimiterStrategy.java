package calculator;

public interface DelimiterStrategy {

    String[] splitNumbers(String input);

    boolean matches(String input);
}
