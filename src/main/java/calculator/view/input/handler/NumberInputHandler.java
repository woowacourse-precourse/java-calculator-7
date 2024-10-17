package calculator.view.input.handler;

import calculator.view.input.service.InputService;

import java.util.function.Function;

public class NumberInputHandler implements InputHandlerService {
    private final InputService inputService;

    public NumberInputHandler(InputService inputService) {
        this.inputService = inputService;
    }

    @Override
    public <R> R receive(Function<String, R> function) {
        String input = inputService.input();
        return function.apply(input);
    }
}
