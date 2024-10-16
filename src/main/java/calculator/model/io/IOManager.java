package calculator.model.io;

public interface IOManager {
    default void printMessage(String message) {
        System.out.println(message);
    };
}
