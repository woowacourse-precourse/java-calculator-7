package calculator.validation;

import calculator.Type.MessageType;
import calculator.exception.MinusSeperatorException;

public class MinusValidator {

    public static void isMinusSeperator(String customSeperator) {

        if (customSeperator.equals("-")) throw new MinusSeperatorException(MessageType.MINUS_SEPERATOR.getMessage());


    }
}
