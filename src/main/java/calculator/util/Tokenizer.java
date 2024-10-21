package calculator.util;

import static calculator.model.enums.ParsingPattern.DELIMITER_TOKEN_FOOTER;
import static calculator.model.enums.ParsingPattern.DELIMITER_TOKEN_HEADER;
import static calculator.model.enums.ParsingPattern.DELIMITER_TOKEN_INDEX;
import static calculator.model.enums.ParsingPattern.DELIMITER_TOKEN_SPLIT_PATTERN;
import static calculator.model.enums.ParsingPattern.NUMBERS_TOKEN_INDEX;
import static calculator.model.enums.ParsingPattern.NUMBERS_TOKEN_SPLIT_LIMIT;
import static calculator.model.enums.ParsingPattern.NUMBERS_TOKEN_SPLIT_PATTERN;

import calculator.model.CustomDelimiterToken;
import calculator.model.NumbersToken;

public class Tokenizer {

    public static CustomDelimiterToken createCustomDelimiterToken(String input) {
        return new CustomDelimiterToken(splitCustomDelimiterToken(input));
    }

    public static NumbersToken createNumbersToken(String input) {
        return new NumbersToken(splitNumbersToken(input));
    }

    public static boolean isExistsCustomDelimiterToken(String input) {
        return input.startsWith(DELIMITER_TOKEN_HEADER.getPattern()) && input.contains(
                DELIMITER_TOKEN_FOOTER.getPattern());
    }

    private static String splitCustomDelimiterToken(String input) {
        return input.split(DELIMITER_TOKEN_SPLIT_PATTERN.getPattern())[DELIMITER_TOKEN_INDEX.getNumber()];
    }

    private static String splitNumbersToken(String input) {
        String[] split = input.split(NUMBERS_TOKEN_SPLIT_PATTERN.getPattern(), NUMBERS_TOKEN_SPLIT_LIMIT.getNumber());

        if (isExistsCustomDelimiterToken(input)) {
            return split[NUMBERS_TOKEN_INDEX.getNumber()];
        }

        return input;
    }
}
