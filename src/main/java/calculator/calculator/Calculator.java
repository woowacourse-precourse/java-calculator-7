package calculator.calculator;

import calculator.utils.ErrorMessage;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private final TokenProvider tokenProvider = new TokenProvider();

    public BigInteger calculate(String rawInput) {
        validateInput(rawInput);
        List<String> tokens = tokenProvider.getTokens(rawInput);

        if (isAllBlank(tokens)) {
            return BigInteger.ZERO;
        }

        return tokens.stream()
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private boolean isAllBlank(List<String> tokens) {
        return tokens.stream().allMatch(String::isBlank);
    }

    private void validateInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_NOT_ALLOWED.getMessage());
        }
    }
}
