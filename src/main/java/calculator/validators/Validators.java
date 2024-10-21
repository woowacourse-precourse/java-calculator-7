package calculator.validators;

import calculator.domain.Calculator;
import java.util.List;

public class Validators {

    public boolean validateDelimiterDeclaration(String inputString) {
        if (inputString.startsWith("//")) {
            if (!inputString.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            return true;
        }
        return false;
    }

    public void validateAllowedCharacters(List<Character> delimiters, String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char delimiter = inputString.charAt(i);
            if (!Character.isDigit(delimiter) && !delimiters.contains(delimiter)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateDelimiterSurroundings(Calculator calculator, String inputString) {
        String[] sections = inputString.split("[" + calculator.getDelimitersAsString() + "]");

        for (int i = 0; i < sections.length; i++) {
            String section = sections[i];

            if (section.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (!isNumber(section)) {
                throw new IllegalArgumentException();
            }
        }


    }

    private boolean isNumber(String section) {
        try {
            Integer.parseInt(section);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
