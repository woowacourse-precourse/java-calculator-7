package calculator.validator;

public class ConsecutiveLetterValidator {
    private String input;
    public ConsecutiveLetterValidator(String input) {
        this.input = input;
        validateConsecutiveLetters();
    }
    private void validateConsecutiveLetters() {
        if (('0' <= input.charAt(0) || input.charAt(0) <= '9') && checkConsecutiveLetter(input)) {
            new IllegalArgumentException("같은 문자가 두 번 연속 입력되었습니다.");
        }
        if(checkConsecutiveLetter(input.substring(5))){
            new IllegalArgumentException("같은 문자가 두 번 연속 입력되었습니다.");
        }
    }
    private boolean checkConsecutiveLetter(String input) {
        char previousChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == previousChar && !Character.isDigit(currentChar)) {
                return true;
            }
            previousChar = currentChar;
        }
        return false;
    }
}
