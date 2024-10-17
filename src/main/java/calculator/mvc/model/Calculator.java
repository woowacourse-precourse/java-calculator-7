package calculator.mvc.model;

import java.util.List;

public interface Calculator {
    void findCustomSeparator(String input);

    void parseNumbersFromString(String input);

    long addNumbers();
}
