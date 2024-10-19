package calculator.exception;

import calculator.domain.MessageType;

public class InvalidInputException extends IllegalArgumentException{

    public InvalidInputException(MessageType messageType){
        super(messageType.getMessage());
    }

}
