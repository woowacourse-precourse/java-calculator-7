package calculator.operation;

import java.util.List;

public interface Calculator {
    Integer calculate(List<String> numbers);
    List<String> extractNumber(String numberPart, List<String> separators);
}
