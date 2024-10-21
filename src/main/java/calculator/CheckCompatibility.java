package calculator;

import java.util.List;

public class CheckCompatibility {

    public void checkInvalidInput(String parsedUserInput, List<Character> delimiter) {
        for (Character checkChar : parsedUserInput.toCharArray()) {
            if (!Character.isDigit(checkChar)) {
                isDelimiter(delimiter, checkChar);
            }
        }
    }

    private void isDelimiter(List<Character> delimiter, Character checkChar) {
        if (!delimiter.contains(checkChar)) {
            throw new IllegalArgumentException("구분자 외의 문자가 있습니다.");
        }
    }
}