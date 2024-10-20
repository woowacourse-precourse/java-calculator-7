package calculator.adder;

import java.util.List;

public final class NumberAdderRequest {

    private final List<String> tokens;

    private NumberAdderRequest(List<String> tokens) {
        this.tokens = tokens;
    }

   public static NumberAdderRequest of(List<String> tokens) {
        return new NumberAdderRequest(tokens);
   }

    public List<String> getTokens() {
        return List.copyOf(tokens);
    }
}
