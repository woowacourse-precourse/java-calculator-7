package calculator.model;

public record Parser(String number) {

    public long parseToLong(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Long.parseLong(number);
    }
}
