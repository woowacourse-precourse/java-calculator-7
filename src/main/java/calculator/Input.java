package calculator;

import static calculator.constants.ExceptionCode.NEGATIVE_OR_ZERO_INPUT;
import static calculator.constants.ExceptionCode.VALID_NUMBER;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] splitBySeparator(Separators separators) {
        if (input.isEmpty()) {
            return new String[0];
        }

        String regex = separators.getRegex();
        return input.split(regex);
    }

    public int[] convertToIntArray(String[] splitStr) {
        if (splitStr.length == 0) {
            return new int[0];
        }

        int[] numbers = parseToIntArray(splitStr);
        validPositiveArray(numbers);
        return numbers;
    }

    private static int[] parseToIntArray(String[] splitStr) {
        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            try {
                numbers[i] = Integer.parseInt(splitStr[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(VALID_NUMBER.getMessage());
            }
        }
        return numbers;
    }

    private static void validPositiveArray(int[] numbers) {
        for (int number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException(NEGATIVE_OR_ZERO_INPUT.getMessage());
            }
        }
    }
}
