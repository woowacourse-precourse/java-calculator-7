package calculator.domain;

import calculator.exception.InvalidInputException;
import calculator.validation.MessageType;

public class Validator {

    private static final String NUMBER_REGEX="[0-9]";

    //구분자가 - 또는 숫자이면 예외를 발생시킨다
    public static void validateSeperator(String customSeperator) {
        checkIfNumber(customSeperator);
        checkIfMinus(customSeperator);
    }

    private static void checkIfNumber(String customSeperator) {
        if (customSeperator.matches(NUMBER_REGEX)){
            throw new InvalidInputException(MessageType.NUMBER_SEPERATOR);
        }
    }

    private static void checkIfMinus(String customSeperator) {
        if (customSeperator.equals("-")){
            throw new InvalidInputException(MessageType.MINUS_SEPERATOR);
        }
    }
}
