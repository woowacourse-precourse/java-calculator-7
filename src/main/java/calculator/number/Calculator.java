package calculator.number;

public interface Calculator<T extends Number> {
    void temporarySave(Character c);

    void save();

    void validateRange(Character c);

    T getTotal();
}
