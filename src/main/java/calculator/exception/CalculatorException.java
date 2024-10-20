package calculator.exception;

public class CalculatorException {

    public static void causeException(String message) {
        throw new IllegalArgumentException(message);
    }

}
