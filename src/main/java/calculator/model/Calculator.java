package calculator.model;

import java.util.List;

public interface Calculator<E> {

    E calculate(List<E> numbers);
}
