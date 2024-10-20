package calculator.validator;

public interface Validator<T> {
    boolean isValid(T value);
}
