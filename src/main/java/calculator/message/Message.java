package calculator.message;

public interface Message {

    String getMessage();

    String getFormatMessage(Object... args);
}
