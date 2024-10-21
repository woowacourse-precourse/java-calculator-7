package calculator.mvc.model;

public interface Calculator {
    void parseNumbersFromString(String input, String regEx);

    long addNumbers();
}
