package calculator.command;

import calculator.domain.Number;
import java.math.BigDecimal;
import java.util.Arrays;

public class SumCommand implements Command {

    @Override
    public String execute(String[] numbers) {
        BigDecimal sum = Arrays.stream(numbers)
                .map(Number::new)
                .map(number -> new BigDecimal(number.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.toPlainString();
    }
}
