package calculator.calculatorApplication.domain.validator.impl;

public interface ValidationRule {
    void validate(String input);

    boolean canHandle(String input);
}
