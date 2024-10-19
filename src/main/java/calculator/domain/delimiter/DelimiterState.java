package calculator.domain.delimiter;

public enum DelimiterState {
    REGISTERED_DELIMITER(true);

    private final boolean state;

    DelimiterState(boolean status) {
        this.state = status;
    }

    public boolean getState() {
        return state;
    }
}
