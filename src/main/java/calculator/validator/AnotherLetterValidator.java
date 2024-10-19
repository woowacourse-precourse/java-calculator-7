package calculator.validator;

public class AnotherLetterValidator {


    public AnotherLetterValidator(String input) {

        validateAnotherLetter(input);
    }

    private void validateAnotherLetter(String input) {
        if (input.charAt(0) != '/' && (input.chars().anyMatch(c -> !Character.isDigit(c) && c != ',' && c != ':'))) {
            throw new IllegalArgumentException("허용되지 않는 문자가 존재합니다.");
        }
        char Separator = input.charAt(2);
        if (input.charAt(0) == '/' && input.substring(5).chars().anyMatch(c -> c != ',' && c != ':' && c != Separator && !Character.isDigit(c))) {
            throw new IllegalArgumentException("허용되지 않는 문자가 존재합니다.");
        }
    }
}
