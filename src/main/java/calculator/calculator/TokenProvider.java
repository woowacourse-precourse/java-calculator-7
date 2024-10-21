package calculator.calculator;

import java.util.List;

public interface TokenProvider {
    List<String> getTokens(String rawInput);
}
