package calculator.number;

public interface StringNumber<T extends Number> {
    void temporarySave(Character c);

    void save();

    void validateRange(Character c);

    T getNumber();
}
