package calculator.model.validator;

public interface InputValidator {
    boolean validate(String input);
    void validateNumbers(String[] splitStrings);
    String findCustomDelimiter(String input);
}
