package calculator;

import java.util.List;

public class Calculater {
    static int calculateInput(String input, List<Character> divisionCharacter) {
        int result = 0;
        int currentDigit = 0;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            boolean isDigit = Character.isDigit(c);
            if(isDigit) {
                currentDigit *= 10;
                currentDigit += convertCharacterToInt(c);
            } else {
                if(divisionCharacter.contains(c)) {
                    result += currentDigit;
                    currentDigit = 0;
                } else {
                    throw new IllegalArgumentException("invalid character, can't be parsed");
                }
            }
        }

        if(currentDigit != 0) {
            result += currentDigit;
        }
        return result;
    }

    static int convertCharacterToInt(char input) {
        return input - '0';
    }
}
