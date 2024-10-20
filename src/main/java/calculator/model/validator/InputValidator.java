package calculator.model.validator;

public interface InputValidator {
    boolean validate(String input);
    int[] parseNumbers(String[] splitStrings);
    String findCustomDelimiter(String input);
}
