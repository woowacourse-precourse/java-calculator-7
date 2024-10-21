package calculator.domain;

public record Number(
        Integer value
) {

    public static Number from(String input) {
        return new Number(Integer.parseInt(input));
    }

    public static Number from(int input) {
        return new Number(input);
    }
}
