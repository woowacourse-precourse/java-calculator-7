package calculator.model.token;

public class NumbersToken {
    private final String token;

    public NumbersToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
