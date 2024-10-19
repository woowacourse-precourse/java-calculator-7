package calculator.model;

public record Parser(String number) {

    public int parseToInt(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
