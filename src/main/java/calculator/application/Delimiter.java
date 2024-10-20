package calculator.application;

public record Delimiter(
    String value
) {

    public static Delimiter from(String value) {
        return new Delimiter(value);
    }
}
