package calculator.validation;

import calculator.Type.MessageType;

//구분자로 숫자를 입력할 때 예외를 발생시킨다
public class NumberValidator {

    public static void isNumberSeperator(String customSeperator) {
        if (customSeperator.matches("[0-9]")){
            throw new IllegalArgumentException(MessageType.NUMBER_SEPERATOR.getMessage());
        }
    }
}
