package calculator.calculator;

import calculator.delimiter.DelimiterFactory;
import calculator.utils.DelimiterUtils;
import calculator.utils.ErrorMessage;
import java.util.List;

public class TokenProvider {

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    private static final String POSITIVE_INTEGER_OR_SPACE_REGEX = "\\s*\\d*\\s*";

    public List<String> getTokens(String rawInput) {
        Delimiter delimiter = delimiterFactory.getDelimiter(rawInput);
        List<String> tokens = delimiter.tokenize(rawInput)
                .stream()
                .map(DelimiterUtils::removeSpaces)
                .toList();

        validateTokens(tokens);
        return tokens;
    }

    private void validateTokens(List<String> extractString) {
        if (extractString.stream().anyMatch(this::isInvalid)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBERS_ALLOWED.getMessage());
        }
    }

    private boolean isInvalid(String token) {
        return !token.matches(POSITIVE_INTEGER_OR_SPACE_REGEX);
    }
}
