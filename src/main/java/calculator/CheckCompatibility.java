package calculator;

import java.util.List;

public class CheckCompatibility {

    public void checkInvalidInput(String parsedUserInput, List<Character> delimiter) {
        for (Character checkChar : parsedUserInput.toCharArray()) {
            if (!Character.isDigit(checkChar)) {
                isdelimiter(delimiter, checkChar);
            }
        }
    }

    private void isdelimiter(List<Character> delimiter, Character checkChar) {
        if(!delimiter.contains(checkChar)) throw new IllegalArgumentException();
    }
}