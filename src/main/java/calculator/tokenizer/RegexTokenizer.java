package calculator.tokenizer;

import java.util.Arrays;
import java.util.List;

public class RegexTokenizer implements Tokenizer {

    private final Delimiters delimiters;

    public RegexTokenizer(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    @Override
    public TokenResponse parse(String input) {
        String delimiterList = concatenateForRegex();

        List<String> seperatedValues = Arrays.stream(input.split(delimiterList))
                .toList();

        return new TokenResponse(seperatedValues);
    }

    private String concatenateForRegex() {
        return "[" + delimiters.concatenate() + "]";
    }

    @Override
    public void setCustomDelimiter(String input) {
        if (!input.contains("\\n")) {
            return;
        }
        String customInput = input.split("[\\\\r\\\\n]+")[0];

        if (!customInput.startsWith("//")) {
            throw new IllegalArgumentException();
        }
        String delimiter = customInput.substring(2);

        delimiters.addCustomDelimiter(delimiter);
    }
}
