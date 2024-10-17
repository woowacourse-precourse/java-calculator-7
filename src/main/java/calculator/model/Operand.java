package calculator.model;

public record Operand(int number) {

    public static Operand from(int number) {
        return new Operand(number);
    }
}
