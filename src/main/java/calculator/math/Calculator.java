package calculator.math;

public interface Calculator<T extends Number> {

    T sum(Iterable<T> list);

}
