package calculator.adder;

import java.util.List;

public interface Addable<T extends Number> {

    T addNumbers(final List<T> numbers);

}
