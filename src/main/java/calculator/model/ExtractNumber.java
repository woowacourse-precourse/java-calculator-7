package calculator.model;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import calculator.util.ValidatorUtil;
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
            return processCustomDelimiter(input);
        }

        return processDefaultDelimiter(input);
    }

    private String[] processCustomDelimiter(String input) {

        String[] splitInput = splitDelimiterAndValue(input);
        String customDelimiter = splitInput[0].substring(2);
        String splitValue = splitInput[1];

        delimiterValidator.validate(splitValue, customDelimiter);
        valueValidator.validate(splitValue, customDelimiter);

        if (ValidatorUtil.isEmptyInput(splitValue) || !splitValue.contains(customDelimiter)) {
            return new String[]{ValidatorUtil.isEmptyInput(splitValue) ? "0" : splitValue};
        }

        return splitValue.split(Pattern.quote(customDelimiter));
    }

    private String[] processDefaultDelimiter(String input) {
        valueValidator.validate(input, DEFAULT_DELIMITERS);
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
