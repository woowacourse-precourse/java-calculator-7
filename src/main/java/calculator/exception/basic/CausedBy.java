package calculator.exception.basic;

public record CausedBy(
        String name,
        String message
) {
    public static CausedBy of(String name, String message) {
        return new CausedBy(name, message);
    }
}
