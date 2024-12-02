package calculator;

import java.util.Optional;

public class Validator {

    public StringType getStringType(String input) {
        if (!input.matches(Regex.CUSTOM_SEPARATOR_REGEX.getPattern())
                && !input.matches(Regex.START_WITH_NUMBER_REGEX.getPattern())) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (input.matches(Regex.CUSTOM_SEPARATOR_REGEX.getPattern())) {
            String str = input.substring(
                    input.indexOf(Sign.CUSTOM_SEPARATOR_POST_SIGN.getSign())
                            + Sign.CUSTOM_SEPARATOR_POST_SIGN.getSign().length()
            );
            String separator = input.substring(
                    2,
                    input.indexOf(Sign.CUSTOM_SEPARATOR_POST_SIGN.getSign())
            );

            return new StringType(str, Optional.of(separator));
        }

        return new StringType(input, Optional.empty());
    }
}
