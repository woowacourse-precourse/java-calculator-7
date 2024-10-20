package calculator.command;

public class DelimiterLine {
    public static final DelimiterLine EMPTY_LINE = new DelimiterLine("");

    private final String value;

    public DelimiterLine(String value) {
        this.value = value;
    }

    public String value() {
        if(isEmpty())
            throw new IllegalStateException("EMPTY_LINE은 값이 없음");
        return value;
    }

    public boolean isEmpty() {
        return this == EMPTY_LINE;
    }
}
