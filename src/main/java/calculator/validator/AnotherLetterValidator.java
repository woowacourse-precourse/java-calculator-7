package calculator.validator;

public class AnotherLetterValidator {
    private String input;
    public AnotherLetterValidator(String input) {
        this.input = input;
        validateAnotherLetter();
    }
    private void validateAnotherLetter() {
        if (input.chars().anyMatch(c -> !Character.isDigit(c) && c != ',')) {
            throw new IllegalArgumentException("허용되지 않는 문자가 존재합니다.");
        }
        char Separator = input.charAt(2);
        if (input.chars().anyMatch(c -> c != ',' && c != Separator && !Character.isDigit(c))) {
            throw new IllegalArgumentException("허용되지 않는 문자가 존재합니다.");
        }
    }
}
