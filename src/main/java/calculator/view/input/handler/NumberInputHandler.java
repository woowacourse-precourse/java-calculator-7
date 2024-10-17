package calculator.view.inputView.handler;

import calculator.number.domain.Number;
import calculator.number.validator.NumberValidator;
import calculator.view.inputView.service.InputService;

import java.util.function.BiFunction;
import java.util.function.Function;

public class NumberInputHandler {
    private final InputService inputService;
    public NumberInputHandler(InputService inputService) {
        this.inputService = inputService;
    }
    public <R extends Number> R retryReceive(BiFunction<String, NumberValidator, R > function, NumberValidator numberValidator) {
            try {
                String input = inputService.input();
                return function.apply(input, numberValidator);
            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return retryReceive(function, numberValidator);
            }
    }
}
