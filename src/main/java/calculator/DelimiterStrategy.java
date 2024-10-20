package calculator;

public interface DelimiterStrategy {

    boolean supports(String input);
    String[] split(String input);

}
