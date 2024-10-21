package calculator.tokenizer;

import java.util.List;

public final class TokenResponse {

    private final List<String> seperatedValues;

    public TokenResponse(List<String> seperatedValues) {
        this.seperatedValues = seperatedValues;
    }

    public List<String> getSeperatedValues() {
        return seperatedValues;
    }
}
