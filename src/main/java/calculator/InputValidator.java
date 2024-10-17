package calculator;

import java.util.ArrayList;

public class InputValidator {

    public void validate(ArrayList<String> values) {
        checkForInvalidInput(values);
    }

    private void checkForInvalidInput(ArrayList<String> values) {
        ArrayList<String> negativeNumbers = new ArrayList<>();
        for (String value : values) {
            try {
                int number = Integer.parseInt(value);
                if (number < 0) {
                    negativeNumbers.add(value);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + value);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
    }
}
