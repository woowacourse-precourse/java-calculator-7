package calculator.view.input.handler;

import java.util.function.Function;

public interface InputHandlerService {
    <R> R receive(Function<String, R> function);
}
