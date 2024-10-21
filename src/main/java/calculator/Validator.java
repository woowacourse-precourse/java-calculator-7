package calculator;

public class Validator {
    public void invalidCustomIdentifierCheck(int lastIndex) {
        if (lastIndex == -1) {
            throw new IllegalArgumentException();
        }
    }

    public void negativeCheck(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
