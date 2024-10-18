package calculator.domain;

import calculator.domain.number.Number;
import calculator.domain.number.Numbers;

public enum Operator {

    PLUS {
        @Override
        public Number apply(Numbers numbers) {
            return new Number(
                    numbers.getNumbers().stream()
                            .mapToInt(Number::getValue)
                            .sum()
            );
        }
    };

    public abstract Number apply(Numbers numbers);
}
