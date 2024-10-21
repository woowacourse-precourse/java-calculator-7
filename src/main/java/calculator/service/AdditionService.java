package calculator.service;

import java.util.List;

import calculator.domain.Delimiter;
import calculator.domain.DelimiterFactory;
import calculator.domain.PositiveNumber;
import calculator.domain.PositiveNumbers;

public class AdditionService {

    public PositiveNumber calculate(final String input) {
        Delimiter delimiter = DelimiterFactory.create(input);
        List<String> numbers = delimiter.split();

        PositiveNumbers positiveNumbers = PositiveNumbers.from(numbers);
        return positiveNumbers.sum();
    }

}
