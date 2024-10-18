package calculator.model;

import java.util.List;

public interface Calculator<E extends Number> {

    E calculate(List<E> numbers);
}
