package calculator;
import java.util.List;


public class NumberTokens {
    private final List<NumberToken> tokens;

    public NumberTokens(List<NumberToken> tokens) {
        this.tokens = tokens;
    }

    public double sum() {
        double total = 0;
        for (NumberToken token : tokens) {
            total += token.getValue();
        }
        return total;
    }
}
