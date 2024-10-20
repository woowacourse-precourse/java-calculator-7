package calculator.domain;

import calculator.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEX="[0-9]{0,}";

    //존재하지 않는 커스텀 구분자 예외발생
    public static void validateCustomSeperator(String num){
        if (!(num.matches(NUMBER_REGEX))){
            throw new InvalidInputException(MessageType.INVALID_SEPERATOR);
        }
    }


}
