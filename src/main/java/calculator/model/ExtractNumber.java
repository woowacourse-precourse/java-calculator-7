package calculator.model;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import calculator.validator.Validator;
import java.util.regex.Pattern;

public class ExtractNumber {

    private final Validator delimiterValidator;
    private final Validator valueValidator;

    public ExtractNumber(Validator delimiterValidator, Validator valueValidator) {
        this.delimiterValidator = delimiterValidator;
        this.valueValidator = valueValidator;
    }

    public String[] extractNumberFromInput(String input) {

        if (input.startsWith("//")) {
            String[] splitInput = splitDelimiterAndValue(input);
            String customDelimiter = splitInput[0].substring(2);
            delimiterValidator.validate(customDelimiter);
            String splitValue = splitInput[1];
            valueValidator.validate(splitValue);

            if (!splitValue.contains(customDelimiter)) {
                return new String[]{splitValue};
            }
            return splitValue.split(Pattern.quote(customDelimiter));
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    private String[] splitDelimiterAndValue(String input) {
        input = input.replace("\\n", "\n");
        String[] parts = input.split("\n", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 계산 될 문자가 없습니다.");
        }
        return parts;
    }
}
