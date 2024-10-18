package calculator;

import java.util.List;

public interface CalculatorImpl {
    void run();
    long calculate(List<Long> numbers);
    void print(long result);
}