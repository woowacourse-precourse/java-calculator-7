package calculator.model.token;

import static calculator.model.token.ParsingPattern.DELIMITER_TOKEN_FOOTER;
import static calculator.model.token.ParsingPattern.DELIMITER_TOKEN_HEADER;
import static calculator.model.token.ParsingPattern.DELIMITER_TOKEN_INDEX;
import static calculator.model.token.ParsingPattern.DELIMITER_TOKEN_SPLIT_PATTERN;
import static calculator.model.token.ParsingPattern.NUMBERS_TOKEN_INDEX;
import static calculator.model.token.ParsingPattern.NUMBERS_TOKEN_SPLIT_LIMIT;
import static calculator.model.token.ParsingPattern.NUMBERS_TOKEN_SPLIT_PATTERN;

public class Tokenizer {

    public CustomDelimiterToken createCustomDelimiterToken(String input) {
        return new CustomDelimiterToken(splitCustomDelimiterToken(input));
    }

    public NumbersToken createNumbersToken(String input) {
        return new NumbersToken(splitNumbersToken(input));
    }

    public boolean isExistsCustomDelimiterToken(String input) {
        return input.startsWith(DELIMITER_TOKEN_HEADER.getPattern()) && input.contains(
                DELIMITER_TOKEN_FOOTER.getPattern());
    }

    private String splitCustomDelimiterToken(String input) {
        return input.split(DELIMITER_TOKEN_SPLIT_PATTERN.getPattern())[DELIMITER_TOKEN_INDEX.getNumber()];
    }

    private String splitNumbersToken(String input) {
        String[] split = input.split(NUMBERS_TOKEN_SPLIT_PATTERN.getPattern(), NUMBERS_TOKEN_SPLIT_LIMIT.getNumber());

        if (isExistsCustomDelimiterToken(input)) {
            return split[NUMBERS_TOKEN_INDEX.getNumber()];
        }

        return input;
    }
}
