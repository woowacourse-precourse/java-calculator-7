package calculator.domain;

import calculator.exception.InvalidInputException;
import calculator.validation.MessageType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEX="[0-9]";

    private static final Pattern NEGATIVE=Pattern.compile("-[0-9]");


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

    //음수를 입력하면 예외 발생
    public static void validatePositive(String input){
        Matcher matcher=NEGATIVE.matcher(input);

        if (matcher.find()) {
            throw new InvalidInputException(MessageType.NEGATIVE_INPUT);
        }
    }

    //존재하지 않는 커스텀 구분자 예외발생


}
