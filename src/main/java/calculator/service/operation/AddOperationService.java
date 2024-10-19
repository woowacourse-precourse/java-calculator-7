package calculator.service.operation;

import calculator.domain.Numbers;

public class AddOperationService implements OperationService {

    @Override
    public int operate(Numbers numbers) {
        return numbers.getValues().stream()
                .mapToInt(number -> number.getValue())
                .sum();
    }
}
