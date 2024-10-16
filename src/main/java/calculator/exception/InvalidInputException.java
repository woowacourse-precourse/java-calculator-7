package calculator.exception;

public class InvalidInputException extends RuntimeException {
    //TODO: 예외 클래스 구현
    public InvalidInputException(String message) {
        super("[ERROR] " + message);
    }
}
