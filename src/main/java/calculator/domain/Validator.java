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

    public static void validateInteger(String num){
        try{
            Integer.parseInt(num);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("특정 수가 int 범위를 넘어갔습니다");
        }
    }
}
