package calculator.domain;

public interface Delimiter {

    boolean supports(String input);

    String[] split(String input);
}
