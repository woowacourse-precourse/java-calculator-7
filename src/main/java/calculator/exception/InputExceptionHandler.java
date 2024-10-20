package calculator.exception;

import calculator.message.ExceptionMessage;
import calculator.model.Separator;

public class InputExceptionHandler {

    public void validateInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public void validateInputFormat(String[] inputSplit) {
        if (Character.isDigit(inputSplit[1].charAt(0))) {
            return;
        } else if (inputSplit[1].startsWith("//")) {
            return;
        } else {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage() + 1);
        }
    }

    public void validateInputNumber(String[] inputSplit, Separator separator) {
        String[] numbers = inputSplit[1].split(
                separator.getComma() + "|" + separator.getColon() + "|" + separator.getCustom());

        for (String number : numbers) {
            if (!number.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage() + 2);
            }
        }
    }
}
