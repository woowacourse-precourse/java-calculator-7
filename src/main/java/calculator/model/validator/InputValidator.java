package calculator.model.validator;

public interface InputValidator {
    boolean validate(String input);
    void validateNumbers(String[] splitStrings);
    Object[] findCustomDelimiter(String input);
}
