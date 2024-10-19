package calculator.exception;

import calculator.validation.MessageType;

public class InvalidInputException extends IllegalArgumentException{

    public InvalidInputException(MessageType messageType){
        super(messageType.getMessage());
    }

}
