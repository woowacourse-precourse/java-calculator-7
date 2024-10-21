package calculator.common;

public class CustomExceptions {

    public static class InvalidDelimiterFormatException extends IllegalArgumentException {
        public InvalidDelimiterFormatException(String message) {
            super(message);
        }
    }

    public static class InvalidNumberException extends IllegalArgumentException {
        public InvalidNumberException(String message) {
            super(message);
        }
    }

    public static class NegativeNumberException extends IllegalArgumentException {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    public static class ArithmeticOverflowException extends ArithmeticException {
        public ArithmeticOverflowException(String message) {
            super(message);
        }
    }

    public static class InvalidCharacterException extends IllegalArgumentException {
        public InvalidCharacterException(String message) {
            super(message);
        }
    }
}
