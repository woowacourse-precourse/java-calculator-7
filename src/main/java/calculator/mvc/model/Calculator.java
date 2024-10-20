package calculator.mvc.model;

public interface Calculator {
    void findCustomSeparator(String input);

    void parseNumbersFromString(String input);

    long addNumbers();
}
