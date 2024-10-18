package calculator.validationRule;

public interface ValidationRule {
    void validate(String input);

    boolean canHandle(String input);
}
