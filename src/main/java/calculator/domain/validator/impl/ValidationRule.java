package calculator.domain.validator.impl;

public interface ValidationRule {
    void validate(String input);

    boolean canHandle(String input);
}
