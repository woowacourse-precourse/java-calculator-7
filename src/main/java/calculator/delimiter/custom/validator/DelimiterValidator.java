package calculator.delimiter.custom.validator;

@FunctionalInterface
public interface DelimiterValidator {

    void validate(String delimiterString);
}
