package calculator.utils;

import calculator.constants.ErrorConst;
import calculator.exception.CanNotParseToNumberException;
import calculator.exception.DelimiterCanNotBeNumberException;
import calculator.exception.InvalidFormatException;
import calculator.exception.InvalidNumberException;
import calculator.exception.NotHaveNextTokenException;

public class ExceptionUtils {

    public static void throwInvalidNumberException() {
        throw new InvalidNumberException(ErrorConst.NUMBER_ERROR);
    }

    public static void throwNotHaveNextTokenException() {
        throw new NotHaveNextTokenException(ErrorConst.NOT_HAVE_NEXT_TOKEN_ERROR);
    }

    public static void throwCanNotParseToNumberException() {
        throw new CanNotParseToNumberException(ErrorConst.CAN_NOT_PARSE_NUMBER_ERROR);
    }

    public static void throwInvalidFormatException() {
        throw new InvalidFormatException(ErrorConst.INVALID_FORMAT_ERROR);
    }

    public static void throwDelimiterCanNotBeNumberException() {
        throw new DelimiterCanNotBeNumberException(ErrorConst.DELIMITER_CAN_NOT_BE_NUMBER_ERROR);
    }


}
