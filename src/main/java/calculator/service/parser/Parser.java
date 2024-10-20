package calculator.service.parser;

public interface Parser<S,T> {
    T parser(S input) throws IllegalArgumentException;
}
