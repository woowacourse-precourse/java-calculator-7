package calculator.model.number.service;

import calculator.util.number.NumberUtils;

import java.util.List;

public class NumberService {

    public List<? extends Number> convertFrom(List<String> value, Class<? extends Number> numberClass) {
        return NumberUtils.parseNumbers(value, numberClass);
    }

    public Number sum(List<? extends Number> numbers, Class<? extends Number> numberClass) {
        return NumberUtils.sum(numbers, numberClass);
    }
}
