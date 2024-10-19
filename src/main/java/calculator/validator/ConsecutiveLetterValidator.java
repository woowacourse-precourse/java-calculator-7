package calculator.validator;

public class ConsecutiveLetterValidator {


    public ConsecutiveLetterValidator(String input) {

        validateConsecutiveLetters(input);
    }

    private void validateConsecutiveLetters(String input) {
        if (input.charAt(0) != '/' && checkConsecutiveLetter(input)) {
            throw new IllegalArgumentException("같은 문자가 두 번 연속 입력되었습니다.");
        }
        if (input.charAt(0) == '/' && checkConsecutiveLetter(input.substring(5))) {
            throw new IllegalArgumentException("같은 문자가 두 번 연속 입력되었습니다.");
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
