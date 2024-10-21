package calculator.utils;

import calculator.constants.ErrorConst;
import calculator.exception.CanNotParseToNumberException;
import calculator.exception.CustomCanNotBeDefaultDelimiterException;
import calculator.exception.CustomDelimiterCanNotBeBlankException;
import calculator.exception.CustomDelimiterLengthMustBeOneException;
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

    public static void throwCustomCanNotBeDefaultDelimiterException() {
        throw new CustomCanNotBeDefaultDelimiterException(ErrorConst.CUSTOM_CAN_NOT_BE_DEFAULT_DELIMITER);
    }

    public static void throwCustomDelimiterLengthMustBeOneException() {
        throw new CustomDelimiterLengthMustBeOneException(ErrorConst.CUSTOM_DELIMITER_LENGTH_MUST_BE_ONE);
    }

    public static void throwCustomDelimiterCanNotBeBlankException() {
        throw new CustomDelimiterCanNotBeBlankException(ErrorConst.CUSTOM_DELIMITER_CAN_NOT_BE_BLANK);
    }


}
