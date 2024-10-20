package calculator.domain;

import calculator.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    // //-\n일 떄 예외발생
    private static final Pattern MINUS_SEPERATOR=Pattern.compile("^//-\\\\n");
    // //3\n일 때 예외발생
    private static final Pattern NUMBER_SEPERATOR=Pattern.compile("^//[0-9]\\\\n");
    //음수 입력시 예외 발생 //?-3
    private static final Pattern NEGATIVE=Pattern.compile("-[0-9]");

    String input;

    public UserInput(String input){
        validateNumberSeperator(input);
        validateMinusSeperator(input);
        validateNegative(input);
        this.input=input;
    }

    private void validateNegative(String input) {
        Matcher matcher=NEGATIVE.matcher(input);

        if (matcher.find()) {
            throw new InvalidInputException(MessageType.NEGATIVE_INPUT);
        }
    }

    private void validateMinusSeperator(String input) {
        Matcher matcher=MINUS_SEPERATOR.matcher(input);

        if (matcher.find()){
            throw new InvalidInputException(MessageType.MINUS_SEPERATOR);
        }
    }

    private void validateNumberSeperator(String input) {
        Matcher matcher=NUMBER_SEPERATOR.matcher(input);

        if (matcher.find()){
            throw new InvalidInputException(MessageType.NUMBER_SEPERATOR);
        }
    }
}
