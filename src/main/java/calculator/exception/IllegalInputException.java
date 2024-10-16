package calculator.exception;

public class IllegalInputException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "잘못된 구분자입니다.";

    public IllegalInputException() {
        super(ERROR_MESSAGE);
    }
}


