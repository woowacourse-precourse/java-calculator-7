package calculator.command;

import calculator.domain.Number;
import java.util.Arrays;

public class SumCommand implements Command {

    @Override
    public int execute(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> new Number(number).getValue())
                .sum();
    }
}
