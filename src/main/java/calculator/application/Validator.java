package calculator.application;

public interface Validator<T> {

    void validate(T target);
}
