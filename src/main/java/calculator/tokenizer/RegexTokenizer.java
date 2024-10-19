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
    public void setDelimiter(String delimiter) {

    }
}
