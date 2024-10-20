package calculator.model;

import java.util.List;

public interface Calculator<T extends Number> {

    T calculate(List<T> numbers);
}
