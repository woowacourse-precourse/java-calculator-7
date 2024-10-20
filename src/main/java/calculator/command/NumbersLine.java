package calculator.command;

public class NumbersLine {
    private final String value;

    public NumbersLine(String value) {
        this.value = value;
    }

    public String value() {
        if(isEmpty())
            throw new IllegalStateException("값이 없음");
        return value;
    }

    public boolean isEmpty() {
        return value == null || value.isBlank();
    }
}
